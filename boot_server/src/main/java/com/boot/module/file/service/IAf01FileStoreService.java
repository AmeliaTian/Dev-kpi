package com.boot.module.file.service;

import com.boot.module.sys.service.IBaseService;
import com.boot.repository.Af01FileStoreVO;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-18 14:44:51
 * @ModifiedBy
 * @ModifiedDate
 */
public interface IAf01FileStoreService extends IBaseService<Af01FileStoreVO> {
    /**
     * 根据文件ID查询记录
     *
     * @param uuid
     * @return
     */
    Af01FileStoreVO queryAf01FileStore(String uuid);
}