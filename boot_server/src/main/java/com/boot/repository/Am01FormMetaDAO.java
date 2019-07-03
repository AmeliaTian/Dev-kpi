package com.boot.repository;

import com.boot.repository.common.BaseDAO;

import java.util.Collection;

/**
 * @author CodeGen
 * @Description 对表AM01_FORM_META的CURD操作
 * @CreateDate 创建时间：2018-07-23 16:49:38
 * @ModifiedBy
 * @ModifiedDate
 */

public interface Am01FormMetaDAO extends BaseDAO<Am01FormMetaPO, String> {
    /**
     * 根据formCode查询表单配置
     *
     * @param formCodes
     * @return
     */
    Iterable<Am01FormMetaPO> findByFormCodeIn(Collection<String> formCodes);
}