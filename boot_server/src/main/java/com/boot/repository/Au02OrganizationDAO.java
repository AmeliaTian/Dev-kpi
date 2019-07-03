package com.boot.repository;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-14 10:33:27
 * @ModifiedBy
 * @ModifiedDate
 */
public interface Au02OrganizationDAO extends BaseDAO<Au02OrganizationPO, String> {


    @Query(value = "select t.ID,t.ORG_NAME,t.ORG_LEADER,t.ORG_DESC,t.OPR_CRT_TIME from au02_organization t where  t.ORG_DESC in ('总部部门','路段公司','创新公司') and t.ORG_NAME <> '外派高管' and t.ORG_NAME <> '工会'" +
            " and t.ORG_NAME <> '总助倪士林' and t.ORG_NAME <> '其他特殊人员' and t.ORG_NAME <> '特殊人员A' order by convert(t.ORG_DESC using gbk) desc,FIELD(t.ORG_NAME,'行政部','党委宣传部','人力资源部','党委办公室','财务部','企业管理部','投资开发部','战略发展部','学会','创新研究院','资本运营部','董事会办公室','安全管理部','风险管理部','监察部','工会','总经理助理'," +
            " '京津塘高速','贵黄公司','甬台温高速','北仑港高速','九瑞高速','桂林公司','鄂东大桥','重庆公司','亳阜高速','华祺投资','招商新智','路宇公司')",nativeQuery = true)
    List<Au02OrganizationPO> findAll();

    @Query(value = "select ID,ORG_NAME,ORG_LEADER,ORG_DESC,OPR_CRT_TIME from au02_organization where id in (SELECT ORG_ID FROM au12_org_user WHERE USER_ID =:userId) ",nativeQuery = true)
    List<Au02OrganizationPO> findDepByUserId(@Param("userId") String userId);

    @Query(value = "select t.ID,t.ORG_NAME,t.ORG_LEADER,t.ORG_DESC,t.OPR_CRT_TIME from au02_organization t where t.ORG_DESC='总部部门' ",nativeQuery = true)
    List<Au02OrganizationPO> findDepByZbbm();

    @Query(value = "select t.ID,t.ORG_NAME,t.ORG_LEADER,t.ORG_DESC,t.OPR_CRT_TIME from au02_organization t where t.ORG_DESC in ('创新公司','路段公司') ",nativeQuery = true)
    List<Au02OrganizationPO> findDepBySsgs();


    @Query(value = "select t.ID,t.ORG_NAME,t.ORG_LEADER,t.ORG_DESC,t.OPR_CRT_TIME from au02_organization t  where t.ORG_LEADER=:fgldid ",nativeQuery = true)
    List<Au02OrganizationPO> findOrgByFgld(@Param("fgldid") String fgldid);



    @Query(value = "select t.ID,t.ORG_NAME,t.ORG_DESC from au02_organization t where t.ORG_DESC in ('总部部门','路段公司','创新公司') order by convert(t.ORG_DESC using gbk) desc,convert(t.ORG_NAME using gbk)",nativeQuery = true)
    List<JSONObject> queryAll();

    //查询用户所在的部门信息
    @Query(value = "select t.ID,t.ORG_NAME,t.ORG_DESC  from au02_organization where id in (SELECT ORG_ID FROM au12_org_user WHERE USER_ID =:userId) ",nativeQuery = true)
    List<JSONObject> queryDepByUserId(@Param("userId") String userId);


    //根据组织id查询分管领导信息
    @Query(value = "select u.ID as USER_ID,u.USER_NAME,u.USER_NAME_CN from au01_user u where u.ID in (select  o.ORG_LEADER from au02_organization o where o.ID=:orgId)" ,nativeQuery = true)
    List<JSONObject> queryOrgFgld(@Param("orgId")String orgId);

    //查询所有的总部部门
    @Query(value = "select t.ID as USER_ID,t.ORG_NAME,t.ORG_DESC from au02_organization t where t.ORG_DESC=:orgDesc order by convert(t.ORG_NAME using gbk)",nativeQuery = true)
    List<JSONObject> queryZbbm(@Param("orgDesc") String orgDesc);



}