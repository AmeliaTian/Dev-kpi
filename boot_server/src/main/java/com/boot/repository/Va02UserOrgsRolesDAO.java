package com.boot.repository;

import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-17 11:27:41
 * @ModifiedBy
 * @ModifiedDate
 */
public interface Va02UserOrgsRolesDAO extends BaseDAO<Va02UserOrgsRolesPO, String> {

    @Query(value="select * from va02_user_orgs_roles", nativeQuery = true)
    List<Va02UserOrgsRolesPO> getALL();

}