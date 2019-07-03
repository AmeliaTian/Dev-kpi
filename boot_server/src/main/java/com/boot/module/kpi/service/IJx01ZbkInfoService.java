package com.boot.module.kpi.service;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.Jx01ZbkInfoPO;
import com.boot.repository.Jx01ZbkInfoVO;
import com.boot.module.sys.service.IBaseService;

import java.util.List;

/**
 * @Description 01指标库 Service
 * @CreateDate 创建时间： 2018-12-26 15:25:20
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface IJx01ZbkInfoService extends IBaseService<Jx01ZbkInfoVO> {
    List<Jx01ZbkInfoPO> getByIdArr(List<String> idList);

    List<JSONObject> getZb();
}