package com.boot.module.kpi.service;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.Jx17ZbdlResultVO;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import com.boot.module.sys.service.IBaseService;

import java.util.List;

/**
 * @Description 考核得分中间表(指标大类得分) Service
 * @CreateDate 创建时间： 2019-05-29 13:47:02
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface IJx17ZbdlResultService extends IBaseService<Jx17ZbdlResultVO> {
    int addZbdlJg(String khnf,String khzq,String khdxid);

    int addZcsrl(String khnf,String khzq,String khdxid);

    JSONObject getDjInfo(String khdxid, String khnf, String khzq);


}