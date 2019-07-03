package com.boot.repository;

import com.boot.repository.common.BaseDAO;

import java.util.List;

/**
 * @Description
 * @CreateDate 创建时间： 2019-01-15 17:56:52
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Au14MenuRoleDAO extends BaseDAO<Au14MenuRolePO, String> {

    List<Au14MenuRolePO>  getByRoleId(String roleId);
}