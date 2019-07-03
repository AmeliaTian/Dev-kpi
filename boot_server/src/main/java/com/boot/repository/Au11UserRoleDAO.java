package com.boot.repository;

import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author CodeGen
 * @Description 对表AU11_USER_ROLE的CURD操作
 * @CreateDate 创建时间：2018-07-23 14:46:21
 * @ModifiedBy
 * @ModifiedDate
 */

public interface Au11UserRoleDAO extends BaseDAO<Au11UserRolePO, String> {

    @Query(value = "select t.ID,t.ROLE_ID,t.USER_ID,t.OPR_CRT_TIME from au11_user_role t where t.USER_ID=:userId",nativeQuery = true)
    List<Au11UserRolePO> findByUserId(@Param("userId") String userId);

    @Query(value = "select t.ID,t.ROLE_ID,t.USER_ID,t.OPR_CRT_TIME from au11_user_role t where t.ROLE_ID=:roleId",nativeQuery = true)
    List<Au11UserRolePO> findByRoleId(@Param("roleId") String roleId);



}