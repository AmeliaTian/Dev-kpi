package com.boot.module.kpi.service;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.Jx23ZzkhzjjgInfoVO;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import com.boot.module.sys.service.IBaseService;

import java.util.List;

/**
 * @Description 23组织考核中间结果表 Service
 * @CreateDate 创建时间： 2019-06-20 11:47:03
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface IJx23ZzkhzjjgInfoService extends IBaseService<Jx23ZzkhzjjgInfoVO> {

    JSONObject getBnddf(String khnf,String khzq,String khdxid);//查询组织半年度的考核成绩

    List<JSONObject> queryKhdx(String userId, String khzq, String khnf);

    List<String> getKhztDfs(String khnf,String khzq,String khdxid);
}