package com.boot.module.kpi.service;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.Jx10BmkhjgResultVO;
import com.boot.repository.Jx21BmglInfoPO;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import com.boot.module.sys.service.IBaseService;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description 10部门考核结果汇总表（包括各等级人数） Service
 * @CreateDate 创建时间： 2019-05-29 13:45:57
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface IJx10BmkhjgResultService extends IBaseService<Jx10BmkhjgResultVO> {
    JSONObject addJg(String khnf, String khzq, String khdxid);
    List<String > queryDj(String khnf,String khzq);
    BigDecimal getGjyjlzzdf(String khnf, String khzq, String khdxid,String orgDesc);
    BigDecimal getZzdf(String khnf, String khzq,String orgId,String orgDesc);
    int  updateGjyjldf(String khnf,String khzq,String orgId,BigDecimal gjyjlzzdf);
    int  updateZzdf( String khnf, String khzq, String orgId, BigDecimal bmkhdf,String khxs);
    List<String> getGlbmDf(String khnf, String khzq, String orgId);
    List<JSONObject> getGlbm(String khnf, String khzq,String orgId);
    BigDecimal getBndDf(String khnf,String orgId);

    Integer updateRS(String khnf,String khzq, String bmid, String bmkhdf);

}