package com.boot.repository;

import com.boot.repository.common.BaseDAO;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-06 11:12:30
 * @ModifiedBy
 * @ModifiedDate
 */
public interface Am02FormMetaItemDAO extends BaseDAO<Am02FormMetaItemPO, String> {
    /**
     * 根据表单id查询
     * @param formId 表单ID
     * @return
     */
    Iterable<Am02FormMetaItemPO> findByFormId(String formId);
}