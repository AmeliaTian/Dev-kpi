package com.boot.module.kpi.service;

import com.boot.repository.Jx16ZqmanageInfoPO;
import com.boot.repository.Jx16ZqmanageInfoVO;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import com.boot.module.sys.service.IBaseService;

import java.util.List;

/**
 * @Description 考核周期阶段管理 Service
 * @CreateDate 创建时间： 2019-03-06 10:16:20
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface IJx16ZqmanageInfoService extends IBaseService<Jx16ZqmanageInfoVO> {
    List<Jx16ZqmanageInfoPO>  queryAll();
}