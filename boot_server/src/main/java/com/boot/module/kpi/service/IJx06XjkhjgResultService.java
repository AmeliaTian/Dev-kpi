package com.boot.module.kpi.service;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.Jx06XjkhjgResultVO;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import com.boot.module.sys.service.IBaseService;

import java.util.List;

/**
 * @Description 06绩效考核结果明细表 Service
 * @CreateDate 创建时间： 2019-04-28 11:37:24
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface IJx06XjkhjgResultService extends IBaseService<Jx06XjkhjgResultVO> {

    List<JSONObject> queryDf(String khnf,String khzq,String khdxId,String khztId,String khdxLb,String zblx);
}