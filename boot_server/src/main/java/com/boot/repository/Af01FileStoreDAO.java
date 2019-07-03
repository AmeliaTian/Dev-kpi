package com.boot.repository;

import com.boot.repository.common.BaseDAO;

/**
 * @author CodeGen
 * @Description 对表AF01_FILE_STORE的CURD操作
 * @CreateDate 创建时间：2018-07-16 16:49:38
 * @ModifiedBy
 * @ModifiedDate
 */

public interface Af01FileStoreDAO extends BaseDAO<Af01FileStorePO, String> {
    /**
     * 根据uuid查询文件
     * @param fileUuid 文件UUID
     * @return
     */
    Af01FileStorePO findByFileUuid(String fileUuid);
}