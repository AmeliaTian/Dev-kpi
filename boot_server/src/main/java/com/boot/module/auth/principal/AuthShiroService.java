package com.boot.module.auth.principal;

import com.boot.constant.WebStroage;
import com.boot.module.auth.service.IAu01UserService;
import com.boot.module.auth.service.IAu03RoleService;
import com.boot.module.auth.service.IAu04PrivilegeService;
import com.boot.module.general.bean.TreeJsonParamsBean;
import com.boot.module.general.service.IAt01JsonObjectService;
import com.boot.repository.*;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author h3dwy
 * @Description 从后台数据库动态加载权限信息
 * @CreateDate 创建时间：2018-09-17 18:08
 * @ModifiedBy
 * @ModifiedDate
 */

@Service("shiroService")
public class AuthShiroService {
    @Resource(name = "au04PrivilegeService")
    private IAu04PrivilegeService au04PrivilegeService;

    @Resource(name = "au03RoleService")
    private IAu03RoleService au03RoleService;

    @Resource(name = "au01UserService")
    private IAu01UserService au01UserService;

    @Resource(name = "at01JsonObjectService")
    private IAt01JsonObjectService at01JsonObjectService;

    @Autowired
    private Va01OrgRolesDAO ordao;

    @Autowired
    private Va02UserOrgsRolesDAO uordao;

    @Autowired
    private ShiroFilterFactoryBean shiroFilterFactoryBean;

    /**
     * 更新资源与用户的配置信息，当对资源重新分配权限时调用
     */
    public void updateAuthPermission() {
        synchronized (shiroFilterFactoryBean) {
            AbstractShiroFilter shiroFilter;
            try {
                shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
            } catch (Exception e) {
                throw new RuntimeException("获取 ShiroFilter 错误!");
            }
            PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
            DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();
            // 清空老的权限控制
            manager.getFilterChains().clear();
            shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();

            // 权限控制map.从数据库获取
            Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
            // 静态资源
            filterChainDefinitionMap.put("/assets/**", "anon");
            // js引用
            filterChainDefinitionMap.put("/all.js", "anon");
            // 设置登录的URL为匿名访问
            filterChainDefinitionMap.put("/auth/login", "anon");
            // 退出系统的过滤器
            filterChainDefinitionMap.put("/auth/logout", "anon");
            // 未登录消息
            filterChainDefinitionMap.put("/auth/nologin", "anon");

            //如："/form/am02FormMetaItem", "restFilter[POST:A,GET:A|B|C]";
            filterChainDefinitionMap.putAll(au04PrivilegeService.resourcePrivilege());
            //最后
            //filterChainDefinitionMap.put("/**", "authc");
            filterChainDefinitionMap.put("/**", "anon");
            shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
            // 重新构建生成
            Map<String, String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
            //
            for (Map.Entry<String, String> entry : chains.entrySet()) {
                String chainDefinition = entry.getValue().trim().replace(" ", "");
                manager.createChain(entry.getKey(), chainDefinition);
            }
        }
    }

    /**
     * 更新所有用户角色,在用户、机构、角色有变化时需要调用此方法进行动态刷新
     * 生成结果如：
     */
    public void refreshUserRoles() {
        System.out.println("+++++++++++refreshUserRoles++++++++++");
        //用户对应机构和角色
        //List<Va02UserOrgsRolesPO> userOrgRolesMapList = uordao.findAll();
        List<Va02UserOrgsRolesPO> userOrgRolesMapList =uordao.getALL();
        //<userId,[OrgId]>
        Map<String, Set<String>> userOrgMapO = new HashMap<>();
        //<userId,[RoleId]>
        Map<String, Set<String>> userRolesMapO = new HashMap<>();
        for (Va02UserOrgsRolesPO va02UserOrgsRolesPO : userOrgRolesMapList) {
            //如果没有这个KEY，则将此KEY的值设置为SET
            userOrgMapO.putIfAbsent(va02UserOrgsRolesPO.getUserId(), new HashSet<>());
            userRolesMapO.putIfAbsent(va02UserOrgsRolesPO.getUserId(), new HashSet<>());
            userOrgMapO.get(va02UserOrgsRolesPO.getUserId()).add(va02UserOrgsRolesPO.getOrgId());
            userRolesMapO.get(va02UserOrgsRolesPO.getUserId()).add(va02UserOrgsRolesPO.getRoleId());
        }

        //机构角色对应
        List<Va01OrgRolesPO> orgRolesMapList = ordao.findAll();
        //<orgid,[roles]>
        Map<String, Set<String>> orgRolesMapO = new HashMap<>();
        for (Va01OrgRolesPO va01OrgRolesPO : orgRolesMapList) {
            orgRolesMapO.putIfAbsent(va01OrgRolesPO.getOrgId(), new HashSet<>());
            orgRolesMapO.get(va01OrgRolesPO.getOrgId()).add(va01OrgRolesPO.getRoleId());
        }

        //所有角色列表
        Iterable<Au03RoleVO> roleList = au03RoleService.queryEntity(null, null);
        //<roleId,role>
        Map<String, Au03RoleVO> rolesO = Lists.newArrayList(roleList).stream().collect(Collectors.toMap(Au03RoleVO::getId, (p) -> p));
        //查询组织树
        Iterable<At01JsonObjectVO> orgTree = at01JsonObjectService.queryEntity(new HashMap<String, Object>() {{
            put("objType", "orgTree");
        }}, null);
        List<TreeJsonParamsBean> treeStruct = new Gson().fromJson(Lists.newArrayList(orgTree).get(0).getObjJson(), new TypeToken<List<TreeJsonParamsBean>>() {
        }.getType());

        Map<String, Set<String>> orgRolesMap = new HashMap<>();
        Set<String> parentRoles = new HashSet<>();
        //获取权限
        checkOrgRoles(treeStruct, orgRolesMapO, parentRoles, orgRolesMap);

        //查询用户列表
        Iterable<Au01UserVO> userList = au01UserService.queryEntity(null, null);
        Map<String, Set<Au03RoleVO>> authUserRolesMapTmp = new ConcurrentHashMap<>();
        for (Au01UserVO au01UserVO : userList) {
            Set<String> userAllRoles = new HashSet<>();
            //用户自身角色
            if (null != userRolesMapO.get(au01UserVO.getId())) {
                userAllRoles.addAll(userRolesMapO.get(au01UserVO.getId()));
            }
            //用户所属机构
            Set<String> userOrgs = userOrgMapO.get(au01UserVO.getId());
            if (null != userOrgs) {
                //如果机构所分配的角色不为空，则添加入角色列表
                userOrgs.stream().filter(userOrg -> null != orgRolesMapO.get(userOrg)).map(orgRolesMap::get).filter(Objects::nonNull).forEach(userAllRoles::addAll);
            }
            //将角色ID转为角色对象
            Set<Au03RoleVO> temRoles = userAllRoles.stream().map(rolesO::get).collect(Collectors.toSet());

            authUserRolesMapTmp.put(au01UserVO.getUserName(), temRoles);
        }

        WebStroage.authUserRolesMap = authUserRolesMapTmp;
    }

    /**
     * 递归获取机构角色
     *
     * @param orgBean
     * @param orgRolesMapO 机构所属角色
     * @param parentRoles  父级权限
     * @param orgRolesMap  本级权限+父级的权限
     */
    private void checkOrgRoles(List<TreeJsonParamsBean> orgBean, Map<String, Set<String>> orgRolesMapO, Set<String> parentRoles, Map<String, Set<String>> orgRolesMap) {

        for (TreeJsonParamsBean orgTreeItem : orgBean) {
            if (null == orgRolesMap.get(orgTreeItem.getNodeId())) {
                orgRolesMap.put(orgTreeItem.getNodeId(), new HashSet<>());
            }
            //获取机构所属角色
            Set<String> itemParentRoles = orgRolesMapO.get(orgTreeItem.getNodeId());
            if (null != itemParentRoles) {
                //加入本级包含的角色
                orgRolesMap.get(orgTreeItem.getNodeId()).addAll(itemParentRoles);
            }
            if (null != parentRoles) {
                //加入父级包含的角色
                orgRolesMap.get(orgTreeItem.getNodeId()).addAll(parentRoles);
            }
            if (CollectionUtils.isNotEmpty(orgTreeItem.getSubNodeList())) {
                //如果有子级，则将本级角色作为父级传入
                checkOrgRoles(orgTreeItem.getSubNodeList(), orgRolesMapO, itemParentRoles, orgRolesMap);
            }
        }
    }
}
