package com.boot.module.form.service;

import com.boot.module.sys.service.IBaseService;
import com.boot.repository.Am01FormMetaVO;

import java.util.List;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-18 14:44:51
 * @ModifiedBy
 * @ModifiedDate
 */
public interface IAm01FormMetaService extends IBaseService<Am01FormMetaVO> {
    /**
     * 根据fromCodes查询信息
     *
     * @param formCodes 表单编码列表
     * @return
     */
    Iterable<Am01FormMetaVO> queryEntityByFormCodes(List<String> formCodes);
}