package com.boot.module.form.service;

import com.boot.module.sys.service.IBaseService;
import com.boot.repository.Am02FormMetaItemVO;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-18 14:44:51
 * @ModifiedBy
 * @ModifiedDate
 */
public interface IAm02FormMetaItemService extends IBaseService<Am02FormMetaItemVO> {

    /**
     * 根据fromIds查询信息
     *
     * @param formId 表单ID
     * @return
     */
    Iterable<Am02FormMetaItemVO> queryEntityByFormId(String formId);

    /**
     * 是否转换待选列表
     *
     * @param vos
     * @param keepOrgin Y保持输入，从SQL中查询
     * @return
     */
    Iterable<Am02FormMetaItemVO> loadMetaValueListFromDb(Iterable<Am02FormMetaItemVO> vos, boolean keepOrgin);
}