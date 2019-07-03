package com.boot.module.kpi.service;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.Jx03YqdzbInfoPO;
import com.boot.repository.Jx03YqdzbInfoVO;
import com.boot.repository.ZbEntity;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import com.boot.module.sys.service.IBaseService;

import java.util.List;

/**
 * @Description 03已签订指标表 Service
 * @CreateDate 创建时间： 2019-04-04 10:38:13
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface IJx03YqdzbInfoService extends IBaseService<Jx03YqdzbInfoVO> {
    int  updateYxbsByid( String id,  String updateUser);
    List<ZbEntity> findZb(String khdxid, String khnf);
    List<ZbEntity> findKhZb(String khdxid,String khnf,String khzq);
    Jx03YqdzbInfoPO findById(String id);
    List<Jx03YqdzbInfoVO> findZbAndYy (String khdxid, String khnf);
    List<Jx03YqdzbInfoPO> getByIdArr(List<String> idList);

    List<JSONObject> queryZbAndSf(String khdxid, String khnf,String khzq);
}