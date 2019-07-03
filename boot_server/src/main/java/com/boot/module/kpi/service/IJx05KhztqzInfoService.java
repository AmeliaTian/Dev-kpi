package com.boot.module.kpi.service;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.Jx05KhztqzInfoPO;
import com.boot.repository.Jx05KhztqzInfoVO;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import com.boot.module.sys.service.IBaseService;


import java.util.List;

/**
 * @Description 05考核主体权重表 Service
 * @CreateDate 创建时间： 2019-03-05 10:30:58
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface IJx05KhztqzInfoService extends IBaseService<Jx05KhztqzInfoVO> {
    List<Jx05KhztqzInfoPO> findByKhdxjsId( String khdxjsid);
    public List<JSONObject> queryUserInfo(String userid, String roleid, String orgId,String zsldid,String zblx);
}