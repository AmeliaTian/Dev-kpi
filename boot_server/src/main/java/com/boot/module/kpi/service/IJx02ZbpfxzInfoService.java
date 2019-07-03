package com.boot.module.kpi.service;

import com.boot.repository.Jx02ZbpfxzInfoVO;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import com.boot.module.sys.service.IBaseService;

import java.util.List;

/**
 * @Description 02指标评分细则 Service
 * @CreateDate 创建时间： 2019-04-09 15:30:22
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface IJx02ZbpfxzInfoService extends IBaseService<Jx02ZbpfxzInfoVO> {
    List<String> findIdByGid(String zbgid);
}