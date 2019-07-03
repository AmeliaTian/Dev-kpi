package com.boot.repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author CodeGen
 * @Description 对表AU01_USER的CURD操作
 * @CreateDate 创建时间：2018-07-23 14:46:21
 * @ModifiedBy
 * @ModifiedDate
 */

public interface Au01UserDAO extends BaseDAO<Au01UserPO, String> {
    /**
     * 根据用户名查询
     * @param userName 用户名
     * @return
     */
    Au01UserPO findByUserName(String userName);
    /**
     * 根据用户名查询
     * @param id 用户名
     * @return
     */
    Au01UserPO findAu01UserPOById(String id);

    @Query(value = "select id  from au01_user t where t.DIRECT_SUPERIOR=:directSuperior",nativeQuery = true)
    List<String > findByDirectSuperior(@Param("directSuperior") String directSuperior);


    @Query(value="select u.id,u.USER_NAME_CN from au01_user u LEFT JOIN au12_org_user ou on u.ID=ou.USER_ID where ou.ORG_ID=:orgId",nativeQuery = true)
    List<JSONObject>  queryByOrgid(@Param("orgId") String orgId);

    @Query(value = "SELECT\n" +
            "\tu.ID AS USER_ID,\n" +
            "\tu.USER_NAME AS USER_NAME,\n" +
            "\tu.USER_NAME_CN AS USER_NAME_CN,\n" +
            "\tu.DIRECT_SUPERIOR AS DIRECT_SUPERIOR,\n" +
            "\trr.ID AS ROLE_ID,\n" +
            "\trr.ROLE_NAME AS ROLE_NAME,\n" +
            "\too.ID AS ORG_ID,\n" +
            "\too.ORG_NAME AS ORG_NAME,\n" +
            "\too.ORG_DESC\n" +
            "FROM\n" +
            "\t(\n" +
            "\t\t(\n" +
            "\t\t\tau01_user u\n" +
            "\t\t\tLEFT JOIN (\n" +
            "\t\t\t\tSELECT\n" +
            "\t\t\t\t\tur.USER_ID AS user_id,\n" +
            "\t\t\t\t\tr.ID AS ID,\n" +
            "\t\t\t\t\tr.ROLE_NAME AS ROLE_NAME,\n" +
            "\t\t\t\t\tr.ROLE_CODE AS ROLE_CODE,\n" +
            "\t\t\t\t\tr.ROLE_DESC AS ROLE_DESC,\n" +
            "\t\t\t\t\tr.OPR_CRT_TIME AS OPR_CRT_TIME\n" +
            "\t\t\t\tFROM\n" +
            "\t\t\t\t\t(\n" +
            "\t\t\t\t\t\tau11_user_role ur\n" +
            "\t\t\t\t\t\tJOIN au03_role r\n" +
            "\t\t\t\t\t)\n" +
            "\t\t\t\tWHERE\n" +
            "\t\t\t\t\t(ur.ROLE_ID = r.ID)\n" +
            "\t\t\t) rr ON ((u.ID = rr.user_id))\n" +
            "\t\t)\n" +
            "\t\tLEFT JOIN (\n" +
            "\t\t\tSELECT\n" +
            "\t\t\t\tuo.USER_ID AS USER_ID,\n" +
            "\t\t\t\to.ID AS ID,\n" +
            "\t\t\t\to.ORG_NAME AS ORG_NAME,\n" +
            "\t\t\t\to.ORG_DESC AS ORG_DESC,\n" +
            "\t\t\t\to.OPR_CRT_TIME AS OPR_CRT_TIME\n" +
            "\t\t\tFROM\n" +
            "\t\t\t\t(\n" +
            "\t\t\t\t\tau02_organization o\n" +
            "\t\t\t\t\tJOIN au12_org_user uo\n" +
            "\t\t\t\t)\n" +
            "\t\t\tWHERE\n" +
            "\t\t\t\t(uo.ORG_ID = o.ID)\n" +
            "\t\t) oo ON ((u.ID = oo.USER_ID))\n" +
            "\t)\n" +
            "WHERE\n" +
            "\trr.ROLE_NAME LIKE CONCAT('%' ,:roleName, '%')\n" +
            "ORDER BY\n" +
            "\tCONVERT (oo.ORG_NAME USING gbk)",nativeQuery = true)
    List<JSONObject> queryByRoleName(@Param("roleName") String roleName);//根据角色查询员工部门角色等信息


    @Query(value = "SELECT\n" +
            "\tu.id,\n" +
            "u.USER_NAME_CN,\n" +
            " r.ROLE_NAME\n" +
            "FROM\n" +
            "\tau01_user u\n" +
            "LEFT JOIN au12_org_user ou ON u.ID = ou.USER_ID\n" +
            "LEFT JOIN au11_user_role ur ON u.ID = ur.USER_ID\n" +
            "LEFT JOIN au03_role r on ur.ROLE_ID=r.ID\n" +
            "WHERE\n" +
            "\tou.ORG_ID =:orgId " +
            "and ur.ROLE_ID in (:roleIds)",nativeQuery = true)
    List<JSONObject> queryByOrgidAndroleName(@Param("orgId") String orgId,@Param("roleIds") String[] roleIds);//查询所属公司正职副职的信息

    @Query(value = "SELECT\n" +
            "\tu.id,\n" +
            "\tu.USER_NAME_CN,\n" +
            "\tr.ROLE_NAME\n" +
            "FROM\n" +
            "\tau01_user u\n" +
            "LEFT JOIN au12_org_user ou ON u.ID = ou.USER_ID\n" +
            "LEFT JOIN au11_user_role ur ON u.ID = ur.USER_ID\n" +
            "LEFT JOIN au03_role r ON ur.ROLE_ID = r.ID\n" +
            "WHERE\n" +
            "\tou.ORG_ID =:orgId\n" +
            "AND ur.ROLE_ID in ('42CELDUPTKW0','4742LUXLX4W0')",nativeQuery = true)
    List<JSONObject> getZzld(@Param("orgId") String orgId);//查询总部部门正职的信息


    @Query(value="select b.id,b.USER_NAME_CN,b.ROLE_NAME from au01_user a  LEFT JOIN (SELECT\n" +
            "\tu.id,\n" +
            "\tu.USER_NAME_CN,\n" +
            "\tr.ROLE_NAME\n" +
            "FROM\n" +
            "\tau01_user u\n" +
            "LEFT JOIN au12_org_user ou ON u.ID = ou.USER_ID\n" +
            "LEFT JOIN au11_user_role ur ON u.ID = ur.USER_ID\n" +
            "LEFT JOIN au03_role r ON ur.ROLE_ID = r.ID\n" +
            "WHERE\n" +
            "\tou.ORG_ID =:orgId\n" +
            "AND ur.ROLE_ID ='42CRAX4V3FGG')b on a.DIRECT_SUPERIOR=b.id\n" +
            "where a.ID=:userid",nativeQuery = true)
    List<JSONObject> getFzLd(@Param("orgId") String orgId,@Param("userid")String userid);





}