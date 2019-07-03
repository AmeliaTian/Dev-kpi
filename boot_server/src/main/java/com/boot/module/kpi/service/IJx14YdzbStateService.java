package com.boot.module.kpi.service;

import com.boot.repository.Jx14YdzbStateVO;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import com.boot.module.sys.service.IBaseService;

import java.util.List;

/**
 * @Description JX14_YDZB_STATE Service
 * @CreateDate 创建时间： 2019-04-04 10:38:57
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface IJx14YdzbStateService extends IBaseService<Jx14YdzbStateVO> {
    int  updateYxbsByid(String khdxid, String khnf);
}