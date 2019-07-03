package com.boot.module.kpi.service;

import com.boot.repository.Jx20ZbwcqkInfoPO;
import com.boot.repository.Jx20ZbwcqkInfoVO;
import com.boot.module.sys.service.IBaseService;


import java.util.List;

/**
 * @Description 20指标完成情况表 Service
 * @CreateDate 创建时间： 2019-04-17 14:36:59
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface IJx20ZbwcqkInfoService extends IBaseService<Jx20ZbwcqkInfoVO> {

    Jx20ZbwcqkInfoPO findBySfmxid(String zbid,String khnf);
}