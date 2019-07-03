package com.boot.module.auth.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.module.auth.service.DeptTreeService;
import com.boot.module.sys.service.BaseService;
import com.boot.repository.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author CodeGen
 * @Description AU02_组织机构表 Service
 * @CreateDate 创建时间： 2018-09-14 10:33:27
 * @ModifiedBy
 * @ModifiedDate
 */
@Service("deptTreeService")
public class DeptTreeServiceImpl extends BaseService implements DeptTreeService{

    @Autowired
    private Au02OrganizationDAO sdao;
    @Autowired
    private Au12OrgUserDAO au12OrgUserDAO;
    @Autowired
    private Au01UserDAO au01UserDAO;
    @Autowired
    private Au11UserRoleDAO au11UserRoleDAO;
    @Autowired
    private Au03RoleDAO au03RoleDAO;
    @Autowired
    private Jx14YdzbStateDAO jx14YdzbStateDAO;
    @Autowired
    private Jx07XjkhcjhzResultDAO jx07XjkhcjhzResultDAO;
    @Autowired
    private Jx11KhzqInfoDAO jx11KhzqInfoDAO;
    /**
     * 查询部门组织架构树(含部门下的人员)
     * 首页  包含人员的签订状态，考核结果
     *
     * @return
     */
    @Override
    public List<DeptTree> queryDeptUserTreeList(String userId,String roleName) {
        String khnf = jx11KhzqInfoDAO.getMaxKhnf();
        List<DeptTree> deptTreeList = new ArrayList<DeptTree>();
        List<Au02OrganizationPO> dList = null;
        /*else if(roleName.equals("分管领导")){
            dList = sdao.findOrgByFgld(userId);
            for (Au02OrganizationPO dt : dList) {
                DeptTree deptTree = new DeptTree();
                Jx14YdzbStatePO qdzt= jx14YdzbStateDAO.findByKhdxid(dt.getId());
                if(qdzt==null){
                    deptTree.setZbydzt("N");
                }else{
                    deptTree.setZbydzt("Y");
                }
                deptTree.setDeptId(dt.getId());
                deptTree.setDeptName(dt.getOrgName());
                deptTree.setDeptDes(dt.getOrgDesc());
                getTreeNodeData(deptTree);
                deptTreeList.add(deptTree);
            }
        }*/if((roleName.indexOf("公司董事长"))!=-1
                ||(roleName.indexOf("公司领导"))!=-1
                ||(roleName.indexOf("系统管理员"))!=-1
                ||(roleName.indexOf("公司总经理"))!=-1){
            //查询所有的部门
             dList = sdao.findAll();
             for (Au02OrganizationPO dt : dList) {
                DeptTree deptTree = new DeptTree();
                Jx14YdzbStatePO qdzt= jx14YdzbStateDAO.findByKhdxid(dt.getId());
                if(qdzt==null){
                    deptTree.setZbydzt("N");
                }else{
                    deptTree.setZbydzt("Y");
                }
                deptTree.setDeptId(dt.getId());
                deptTree.setDeptName(dt.getOrgName());
                deptTree.setDeptDes(dt.getOrgDesc());
                getTreeNodeData(deptTree);
                deptTreeList.add(deptTree);
            }
        }else if(roleName.indexOf("总部部门正职")!=-1||(roleName.indexOf("总部部门副职"))!=-1){
                dList = sdao.findDepByUserId(userId);
                for (Au02OrganizationPO dt : dList) {
                    DeptTree deptTree = new DeptTree();
                    Jx14YdzbStatePO qdzt= jx14YdzbStateDAO.findByKhdxid(dt.getId());
                    if(qdzt==null){
                        deptTree.setZbydzt("N");
                    }else{
                        deptTree.setZbydzt("Y");
                    }
                    deptTree.setDeptId(dt.getId());
                    deptTree.setDeptName(dt.getOrgName());
                    deptTree.setDeptDes(dt.getOrgDesc());
                    getTreeNodeData(deptTree);
                    deptTreeList.add(deptTree);
                }
            }
        /*else if(roleName.equals("归口部")){
            dList =  sdao.findDepByLdgs();
            for (Au02OrganizationPO dt : dList) {
                DeptTree deptTree = new DeptTree();
                Jx14YdzbStatePO qdzt= jx14YdzbStateDAO.findByKhdxid(dt.getId());
                if(qdzt==null){
                    deptTree.setZbydzt("N");
                }else{
                    deptTree.setZbydzt("Y");
                }
                deptTree.setDeptId(dt.getId());
                deptTree.setDeptName(dt.getOrgName());
                deptTree.setDeptDes(dt.getOrgDesc());
                deptTree.setChildrenList(null);
                deptTreeList.add(deptTree);
            }
        }else if(roleName.equals("战略发展部")){
            dList =  sdao.findDepByCxgs();
            for (Au02OrganizationPO dt : dList) {
                DeptTree deptTree = new DeptTree();
                Jx14YdzbStatePO qdzt= jx14YdzbStateDAO.findByKhdxid(dt.getId());
                if(qdzt==null){
                    deptTree.setZbydzt("N");
                }else{
                    deptTree.setZbydzt("Y");
                }
                deptTree.setDeptId(dt.getId());
                deptTree.setDeptName(dt.getOrgName());
                deptTree.setDeptDes(dt.getOrgDesc());
                deptTree.setChildrenList(null);
                deptTreeList.add(deptTree);
            }
        }*/
        return deptTreeList;
    }

    /**
     * 查询部门组织架构树(含部门下的人员)
     * 审核对象  员工的审核 包含签订状态
     * @param userId
     * @param roleName
     * @return
     */
    public List<DeptTree> queryDeptUserTreeList1(String userId,String roleName) {
        String khnf = jx11KhzqInfoDAO.getMaxKhnf();
        List<DeptTree> deptTreeList = new ArrayList<DeptTree>();
        List<Au02OrganizationPO> dList = null;
        if(roleName.indexOf("总部部门正职")!=-1){
            dList = sdao.findDepByUserId(userId);
            for (Au02OrganizationPO dt : dList) {
                DeptTree deptTree = new DeptTree();
                Jx14YdzbStatePO qdzt= jx14YdzbStateDAO.findByKhdxid(dt.getId());
                if(qdzt==null){
                    deptTree.setZbydzt("N");
                }else{
                    deptTree.setZbydzt("Y");
                }
                deptTree.setDeptId(dt.getId());
                deptTree.setDeptName(dt.getOrgName());
                deptTree.setDeptDes(dt.getOrgDesc());
                getShdxTreeNodeData(deptTree);
                deptTreeList.add(deptTree);
            }
        }else if(roleName.indexOf("分管领导")!=-1){
            dList = sdao.findOrgByFgld(userId);
            for (Au02OrganizationPO dt : dList) {
                DeptTree deptTree = new DeptTree();
                Jx14YdzbStatePO qdzt= jx14YdzbStateDAO.findByKhdxid(dt.getId());
                if(qdzt==null){
                    deptTree.setZbydzt("N");
                }else{
                    deptTree.setZbydzt("Y");
                }
                deptTree.setDeptId(dt.getId());
                deptTree.setDeptName(dt.getOrgName());
                deptTree.setDeptDes(dt.getOrgDesc());
                getShdxTreeNodeData(deptTree);
                deptTreeList.add(deptTree);
            }
        }
        return deptTreeList;
    }

    /**
     * 查询部门组织架构树(含部门下的人员)
     * 统计报表   只包含人员 角色等信息
     * @return
     */
    @Override
    public List<DeptTree> queryUserTreeList(String userId,String roleName) {
        String khnf = jx11KhzqInfoDAO.getMaxKhnf();
        List<DeptTree> deptTreeList = new ArrayList<DeptTree>();
        List<Au02OrganizationPO> dList = null;
       if((roleName.indexOf("公司董事长"))!=-1
                ||(roleName.indexOf("公司领导"))!=-1
                ||(roleName.indexOf("系统管理员"))!=-1
                ||(roleName.indexOf("公司总经理"))!=-1
                /*||(roleName.indexOf("分管领导"))!=-1*/){
            dList = sdao.findAll();
            for (Au02OrganizationPO dt : dList) {
                DeptTree deptTree = new DeptTree();
                Jx14YdzbStatePO qdzt= jx14YdzbStateDAO.findByKhdxid(dt.getId());
                deptTree.setDeptId(dt.getId());
                deptTree.setDeptName(dt.getOrgName());
                deptTree.setDeptDes(dt.getOrgDesc());
                getUserTreeNodeData(deptTree);
                deptTreeList.add(deptTree);
            }
        }else if(roleName.indexOf("总部部门正职")!=-1||(roleName.indexOf("总部部门副职"))!=-1){
            dList = sdao.findDepByUserId(userId);
            for (Au02OrganizationPO dt : dList) {
                DeptTree deptTree = new DeptTree();
                deptTree.setDeptId(dt.getId());
                deptTree.setDeptName(dt.getOrgName());
                deptTree.setDeptDes(dt.getOrgDesc());
                getUserTreeNodeData(deptTree);
                deptTreeList.add(deptTree);
            }
        }
        return deptTreeList;
    }

    /**
     * 为每个部门插入相关人员
     *
     * @param
     * @return
     */
    public void getTreeNodeData(DeptTree dt) {
        String khnf = jx11KhzqInfoDAO.getMaxKhnf();
        //根据部门id查询所有的人员
        List<Au12OrgUserPO> userList = au12OrgUserDAO.findUserIdByOrgId(dt.getDeptId());
        List<Au01UserVO> au01UserVOList=new ArrayList<Au01UserVO>();
        for (int i = 0; i <userList.size(); i++) {
            Au01UserPO byUserId = au01UserDAO.findAu01UserPOById(userList.get(i).getUserId());
            Au01UserVO au01UserVO=new Au01UserVO();
            au01UserVO.setId(byUserId.getId());
            au01UserVO.setUserName(byUserId.getUserName());
            au01UserVO.setUserNameCn(byUserId.getUserNameCn());
            au01UserVO.setPassword(byUserId.getPassword());
            au01UserVO.setDirectSuperior(byUserId.getDirectSuperior());
            String userId = byUserId.getId();
            if(StringUtils.isNotEmpty(userId)){
                List<Au11UserRolePO> userRolePOs = au11UserRoleDAO.findByUserId(userId);
                List<Au03RoleVO> au03RoleVOS=new ArrayList<Au03RoleVO>();
                for(Au11UserRolePO userRolePO:userRolePOs){
                    String id = userRolePO.getRoleId();
                    Au03RolePO au03RolePO = au03RoleDAO.findAu03RolePOByRoleId(id);
                    Au03RoleVO au03RoleVO=new Au03RoleVO();
                    au03RoleVO.setId(au03RolePO.getId());
                    au03RoleVO.setRoleCode(au03RolePO.getRoleCode());
                    au03RoleVO.setRoleDesc(au03RolePO.getRoleDesc());
                    au03RoleVO.setRoleName(au03RolePO.getRoleName());
                    au03RoleVOS.add(au03RoleVO);
                }
                au01UserVO.setUserRoles(au03RoleVOS);
                Jx14YdzbStatePO qdzt= jx14YdzbStateDAO.findByKhdxid(userList.get(i).getUserId());
                if(qdzt==null){
                    au01UserVO.setYdzbState("N");
                    au01UserVO.setJx14YdzbStatePO(qdzt);
                }else{
                    au01UserVO.setYdzbState("Y");
                    au01UserVO.setJx14YdzbStatePO(qdzt);
                }
               // System.out.println(((Au12OrgUserPO)userList.get(i)).getUserId()+"-------------------------");
                List<Jx07XjkhcjhzResultPO> jx07XjkhcjhzResultPOS = this.jx07XjkhcjhzResultDAO.findByKhdxid1(((Au12OrgUserPO)userList.get(i)).getUserId(), khnf);
                au01UserVO.setJx07XjkhcjhzResultPOList(jx07XjkhcjhzResultPOS);
            }
            au01UserVOList.add(au01UserVO);
        }
        dt.setChildrenList(au01UserVOList);
    }

    public void getShdxTreeNodeData(DeptTree dt) {
        String khnf = jx11KhzqInfoDAO.getMaxKhnf();
        List<Au12OrgUserPO> userList = au12OrgUserDAO.findUserIdByOrgId(dt.getDeptId());
        List<Au01UserVO> au01UserVOList=new ArrayList<Au01UserVO>();
        for (int i = 0; i <userList.size(); i++) {
            Au01UserPO byUserId = au01UserDAO.findAu01UserPOById(userList.get(i).getUserId());
            Au01UserVO au01UserVO=new Au01UserVO();
            au01UserVO.setId(byUserId.getId());
            au01UserVO.setUserName(byUserId.getUserName());
            au01UserVO.setUserNameCn(byUserId.getUserNameCn());
            au01UserVO.setPassword(byUserId.getPassword());
            au01UserVO.setDirectSuperior(byUserId.getDirectSuperior());
            String userId = byUserId.getId();
            if(StringUtils.isNotEmpty(userId)){
                List<Au11UserRolePO> userRolePOs = au11UserRoleDAO.findByUserId(userId);
                List<Au03RoleVO> au03RoleVOS=new ArrayList<Au03RoleVO>();
                for(Au11UserRolePO userRolePO:userRolePOs){
                    String id = userRolePO.getRoleId();
                    Au03RolePO au03RolePO = au03RoleDAO.findAu03RolePOByRoleId(id);
                    Au03RoleVO au03RoleVO=new Au03RoleVO();
                    au03RoleVO.setId(au03RolePO.getId());
                    au03RoleVO.setRoleCode(au03RolePO.getRoleCode());
                    au03RoleVO.setRoleDesc(au03RolePO.getRoleDesc());
                    au03RoleVO.setRoleName(au03RolePO.getRoleName());
                    au03RoleVOS.add(au03RoleVO);
                }
                au01UserVO.setUserRoles(au03RoleVOS);
                Jx14YdzbStatePO qdzt= jx14YdzbStateDAO.findByKhdxid(userList.get(i).getUserId());
                if(qdzt==null){
                    au01UserVO.setYdzbState("N");
                    au01UserVO.setJx14YdzbStatePO(qdzt);
                }else{
                    au01UserVO.setYdzbState("Y");
                    au01UserVO.setJx14YdzbStatePO(qdzt);
                }
            }
            au01UserVOList.add(au01UserVO);
        }
        dt.setChildrenList(au01UserVOList);
    }

    public void getUserTreeNodeData(DeptTree dt) {
        String khnf = jx11KhzqInfoDAO.getMaxKhnf();
        List<Au12OrgUserPO> userList = au12OrgUserDAO.findUserIdByOrgId(dt.getDeptId());
        List<Au01UserVO> au01UserVOList=new ArrayList<Au01UserVO>();
        for (int i = 0; i <userList.size(); i++) {
            Au01UserPO byUserId = au01UserDAO.findAu01UserPOById(userList.get(i).getUserId());
            Au01UserVO au01UserVO=new Au01UserVO();
            au01UserVO.setId(byUserId.getId());
            au01UserVO.setUserName(byUserId.getUserName());
            au01UserVO.setUserNameCn(byUserId.getUserNameCn());
            au01UserVO.setPassword(byUserId.getPassword());
            au01UserVO.setDirectSuperior(byUserId.getDirectSuperior());
            String userId = byUserId.getId();
            if(StringUtils.isNotEmpty(userId)){
                List<Au11UserRolePO> userRolePOs = au11UserRoleDAO.findByUserId(userId);
                List<Au03RoleVO> au03RoleVOS=new ArrayList<Au03RoleVO>();
                for(Au11UserRolePO userRolePO:userRolePOs){
                    String id = userRolePO.getRoleId();
                    Au03RolePO au03RolePO = au03RoleDAO.findAu03RolePOByRoleId(id);
                    Au03RoleVO au03RoleVO=new Au03RoleVO();
                    au03RoleVO.setId(au03RolePO.getId());
                    au03RoleVO.setRoleCode(au03RolePO.getRoleCode());
                    au03RoleVO.setRoleDesc(au03RolePO.getRoleDesc());
                    au03RoleVO.setRoleName(au03RolePO.getRoleName());
                    au03RoleVOS.add(au03RoleVO);
                }
                au01UserVO.setUserRoles(au03RoleVOS);
            }
            au01UserVOList.add(au01UserVO);
        }
        dt.setChildrenList(au01UserVOList);
    }

    public List<Au01UserVO> getTreeNodeData1(String directSuperior) {
        String khnf = jx11KhzqInfoDAO.getMaxKhnf();
        List<String> userList = au01UserDAO.findByDirectSuperior(directSuperior);
        List<Au01UserVO> au01UserVOList=new ArrayList<Au01UserVO>();
        for (int i = 0; i <userList.size(); i++) {
            Au01UserPO byUserId = au01UserDAO.findAu01UserPOById(userList.get(i));
            Au01UserVO au01UserVO=new Au01UserVO();
            au01UserVO.setId(byUserId.getId());
            au01UserVO.setUserName(byUserId.getUserName());
            au01UserVO.setUserNameCn(byUserId.getUserNameCn());
            au01UserVO.setPassword(byUserId.getPassword());
            au01UserVO.setDirectSuperior(byUserId.getDirectSuperior());
            String userId = byUserId.getId();
            if(StringUtils.isNotEmpty(userId)){
                List<Au11UserRolePO> userRolePOs = au11UserRoleDAO.findByUserId(userId);
                List<Au03RoleVO> au03RoleVOS=new ArrayList<Au03RoleVO>();
                for(Au11UserRolePO userRolePO:userRolePOs){
                    String id = userRolePO.getRoleId();
                    Au03RolePO au03RolePO = au03RoleDAO.findAu03RolePOByRoleId(id);
                    Au03RoleVO au03RoleVO=new Au03RoleVO();
                    au03RoleVO.setId(au03RolePO.getId());
                    au03RoleVO.setRoleCode(au03RolePO.getRoleCode());
                    au03RoleVO.setRoleDesc(au03RolePO.getRoleDesc());
                    au03RoleVO.setRoleName(au03RolePO.getRoleName());
                    au03RoleVOS.add(au03RoleVO);
                }
                au01UserVO.setUserRoles(au03RoleVOS);

                Jx14YdzbStatePO qdzt= jx14YdzbStateDAO.findByKhdxid(userList.get(i));
                if(qdzt==null){
                    au01UserVO.setYdzbState("N");
                    au01UserVO.setJx14YdzbStatePO(qdzt);
                }else{
                    au01UserVO.setYdzbState("Y");
                    au01UserVO.setJx14YdzbStatePO(qdzt);
                }
                List<Jx07XjkhcjhzResultPO> jx07XjkhcjhzResultPOS = jx07XjkhcjhzResultDAO.findByKhdxid1(userList.get(i),khnf);
                au01UserVO.setJx07XjkhcjhzResultPOList(jx07XjkhcjhzResultPOS);

            }
            au01UserVOList.add(au01UserVO);
        }
        return au01UserVOList;
    }

    @Override
    public Long countEntity(Map<String, Object> queryParamMap) {
        return null;
    }

    @Override
    public Iterable<Au01UserVO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable) {
        return null;
    }

    @Override
    public Integer updateEntity(List<Au01UserVO> au01UserVOS) {
        return null;
    }

    @Override
    public Integer saveEntity(List<Au01UserVO> au01UserVOS) {
        return null;
    }

    @Override
    public Integer removeEntity(List<String> ids) {
        return null;
    }


    public List getUserInfo(String userId,String roleName,String khzq,String khnf){
        List<JSONObject> depList=new ArrayList<>();
        if(roleName.indexOf("总部部门正职")!=-1||(roleName.indexOf("总部部门副职"))!=-1){
            depList = sdao.queryDepByUserId(userId);//查询所在部门
        }else if((roleName.indexOf("公司董事长"))!=-1
                ||(roleName.indexOf("公司领导"))!=-1
                ||(roleName.indexOf("人力资源部"))!=-1
                ||(roleName.indexOf("公司总经理"))!=-1){
            depList = sdao.queryAll();//查询所有的部门
        }
        return getUser(depList,khzq,khnf);
    }


    /*public List queryUserByRole(String roleName){
        List<JSONObject> depList=new ArrayList<>();

    }*/

    public List getUser(List<JSONObject> depList,String khzq,String khnf){
        List<JSONObject> list=new ArrayList<JSONObject>();
        for(JSONObject o:depList){
            JSONObject dep=new JSONObject();
            dep.put("deptId",o.get("ID"));
            dep.put("deptName",o.get("ORG_NAME"));
            dep.put("deptDes",o.get("ORG_DESC"));
            //查询部门中的人员信息
            List<JSONObject> userList = au01UserDAO.queryByOrgid(o.getString("ID"));
            List<JSONObject> userList1=new ArrayList<JSONObject>();
            for(JSONObject user:userList){
                //查询角色
                List<JSONObject> roleList = au03RoleDAO.queryByUserid(user.getString("id"));
                user.put("userRoles",roleList);
               /* String ydzt = jx14YdzbStateDAO.queryZt(user.getString("id"), khnf);
                user.put("zbqdzt",ydzt);
                JSONObject khjg = jx07XjkhcjhzResultDAO.getByKhdxid(user.getString("id"), khnf, khzq);
                user.put("khjg",khjg);*/
                userList1.add(user);
            }
            dep.put("childrenList",userList1);
            list.add(dep);
        }
        return list;
    }

}
