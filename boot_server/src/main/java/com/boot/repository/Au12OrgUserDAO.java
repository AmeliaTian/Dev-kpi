package com.boot.repository;

import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-13 16:00:19
 * @ModifiedBy
 * @ModifiedDate
 */
public interface Au12OrgUserDAO extends BaseDAO<Au12OrgUserPO, String> {

    @Query(value = "select * from au12_org_user  aou where aou.USER_ID in ( SELECT uor.USER_ID from  va02_user_orgs_roles  uor where uor.ORG_ID=:orgId and uor.ROLE_ID <> '4A3398BMOHDS') and aou.ORG_ID=:orgId",nativeQuery = true)
    List<Au12OrgUserPO> findUserIdByOrgId(@Param("orgId") String orgId);
   /* List<Au12OrgUserPO> findUserIdByOrgId(String orgId);*/

    Au12OrgUserPO findByUserId(String userId);

    @Query(value = "select ORG_ID from au12_org_user where USER_ID=:userid",nativeQuery = true)
    List<String> findOrgIdByUserId(@Param("userid") String userid);
}