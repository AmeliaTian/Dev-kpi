package com.boot.module.auth.service.impl;

import com.boot.constant.WebConstants;
import com.boot.eventlistener.PrivilegeChangeEvent;
import com.boot.module.auth.service.IAu03RoleService;
import com.boot.module.auth.service.IAu04PrivilegeService;
import com.boot.module.sys.ConvertBeanTools;
import com.boot.repository.common.JpaSpecificationBuilder;
import com.boot.module.sys.ObjectBeanTools;
import com.boot.module.sys.service.BaseService;
import com.boot.repository.*;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author CodeGen
 * @Description AU04_权限(资源表)表 Service
 * @CreateDate 创建时间： 2018-09-18 14:44:51
 * @ModifiedBy
 * @ModifiedDate
 */
@Service("au04PrivilegeService")
public class Au04PrivilegeServiceImpl extends BaseService implements IAu04PrivilegeService {

    //用于注册事件
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Au04PrivilegeDAO sdao;

    @Resource(name = "au03RoleService")
    private IAu03RoleService au03RoleService;

    @Override
    public Long countEntity(Map<String, Object> queryParamMap) {
        return sdao.count(new JpaSpecificationBuilder<>(queryParamMap, Au04PrivilegePO.class));
    }

    @Override
    public Iterable<Au04PrivilegeVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        JpaSpecificationBuilder specification = new JpaSpecificationBuilder<>(queryParamMap, Au04PrivilegePO.class);

        Iterable<Au04PrivilegePO> dataPO = null;
        if (null == pageable) {
            dataPO = sdao.findAll(specification);
        } else {
            dataPO = sdao.findAll(specification, pageable).getContent();
        }
        return ConvertBeanTools.convertGroupToVO(dataPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateEntity(List<Au04PrivilegeVO> au04PrivilegeVOS) {
        //更新，则不论VO中是否有参数为null均向后台更新,false
        Iterable<Au04PrivilegePO> poList = ConvertBeanTools.convertGroupToPO(au04PrivilegeVOS, false);

        int count = sdao.saveAll(poList).size();
        //发布权限变更事件
        applicationContext.publishEvent(new PrivilegeChangeEvent(this));
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveEntity(List<Au04PrivilegeVO> au04PrivilegeVOS) {
        //patch，则只将不为null的值更新到后台
        Map<String, Au04PrivilegePO> voMap = new HashMap<>(au04PrivilegeVOS.size());
        for (Au04PrivilegeVO t : au04PrivilegeVOS) {
            voMap.put(t.getId(), ConvertBeanTools.convertToPO(t, true));
        }
        //如果数据库中有这些数据，则查询出来，将更新值替换查询值后，重新放入map中
        Iterable<Au04PrivilegePO> poList = sdao.findAllById(voMap.keySet());
        for (Au04PrivilegePO p : poList) {
            ObjectBeanTools.copyPropertiesIgnoreNull(voMap.get(p.getId()), p);
            //替换
            voMap.put(p.getId(), p);
        }

        int count = sdao.saveAll(voMap.values()).size();
        //发布权限变更事件
        applicationContext.publishEvent(new PrivilegeChangeEvent(this));
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer removeEntity(List<String> ids) {
        QAu04PrivilegePO qpo = QAu04PrivilegePO.au04PrivilegePO;
        int count=Long.valueOf(queryFactory.delete(qpo).where(qpo.id.in(ids)).execute()).intValue();
        //发布权限变更事件
        applicationContext.publishEvent(new PrivilegeChangeEvent(this));
        return count;
    }

    /**
     * 将url资源与角色进行拆分拼接
     * ---------
     * 由格式:
     * form/am02FormMetaItem,POST,["A.id"]
     * form/am02FormMetaItem,GET,["A.id","B.id","C.id"]
     * 转换为：
     * "/form/am02FormMetaItem", "restFilter[POST:A,GET:A|B|C]"
     *
     * @return
     */
    @Override
    public Map<String, String> resourcePrivilege() {
        Iterable<Au04PrivilegeVO> privList = this.queryEntity(null, null);
        //分组<资源url,[权限对象]>
        Map<String, List<Au04PrivilegeVO>> privGroup = Lists.newArrayList(privList).stream().collect(Collectors.groupingBy(Au04PrivilegeVO::getPrivResource));
        //
        Iterable<Au03RoleVO> roleList = au03RoleService.queryEntity(null, null);
        //<roleId,roleCode>
        Map<String, String> roleMap = Lists.newArrayList(roleList).stream().collect(Collectors.toMap(Au03RoleVO::getId, Au03RoleVO::getRoleCode));
        //
        Map<String, String> resRolesMap = new HashMap<>();
        //<POST,[ROLES]>
        for (Map.Entry<String, List<Au04PrivilegeVO>> resourceMap : privGroup.entrySet()) {
            Map<String, Set<String>> methMap = new HashMap<>();
            //<资源url,[权限对象]>
            for (Au04PrivilegeVO au04PrivilegeVO : resourceMap.getValue()) {
                Set<String> tmpSet = new HashSet<>();
                if (WebConstants.IS_YES_STR.equals(au04PrivilegeVO.getPrivUnlogin())) {
                    //表示非登录也可登录
                    tmpSet.add(WebConstants.ALLOW_UNLOGIN_USERS_INVOKE_NAME);
                } else if (StringUtils.isNotEmpty(au04PrivilegeVO.getPrivRoles()) && !"[]".equals(au04PrivilegeVO.getPrivRoles())) {
                    List<String> rolesIds = new Gson().fromJson(au04PrivilegeVO.getPrivRoles(), new TypeToken<List<String>>() {}.getType());
                    for (String rid : rolesIds) {
                        //如果角色已经删除，则不添加
                        if (null != roleMap.get(rid)) {
                            //添加角色编码
                            tmpSet.add(roleMap.get(rid));
                        }
                    }
                } else {
                    //分配角色为空，则表示所有角色都可访问
                    tmpSet.add(WebConstants.ALLOW_ALL_ROLES_INVOKE_NAME);
                }
                methMap.put(au04PrivilegeVO.getPrivMethod(), tmpSet);
            }
            Set<String> checkRoles = new HashSet<>();
            //<POST,[ROLES]>
            methMap.forEach((key, value) -> {
                //GET:A|B|C
                checkRoles.add(key + ":" + String.join("|", value));
            });
            //restFilter[POST:A,GET:A|B|C]
            resRolesMap.put(resourceMap.getKey(), "restFilter[" + String.join(",", checkRoles) + "]");
        }
        return resRolesMap;
    }
}