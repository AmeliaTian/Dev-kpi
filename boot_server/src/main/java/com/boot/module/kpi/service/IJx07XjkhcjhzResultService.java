package com.boot.module.kpi.service;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.Jx07XjkhcjhzResultPO;
import com.boot.repository.Jx07XjkhcjhzResultVO;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import com.boot.module.sys.service.IBaseService;

import java.util.List;

/**
 * @Description 07绩效考核汇总表 Service
 * @CreateDate 创建时间： 2019-03-04 11:17:20
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface IJx07XjkhcjhzResultService extends IBaseService<Jx07XjkhcjhzResultVO> {

    List<JSONObject> queryKhjg(String userId, String roleName, String khnf, String khzq,String khdxlx);

    List<JSONObject> queryKhjg(String khdxId, String khnf);

    List<JSONObject> queryDjCount(String khnf, String khzq,String bmmc);

    List<JSONObject> queryFsCount(String khnf, String khzq,String bmmc);

    String getYgDf(String khdxid,String khnf, String khzq);

    String getZcNdDf(String khdxid,String khnf, String khzq,String khdxjs,String bmmc);

    int updateDj(String khdxid,String khnf, String khzq,String bmmc,String khdxjs);

    int  updateDj(String khnf, String khzq, String bmmc,String bmid);

    String addTeShu(String khdxId, String khdxName, String khdxLb, String khnf, String khzq, String khdxjs, String bmmc);

    /*List<JSONObject> getKhdjFenPei(String khnf, String khzq);*/
}