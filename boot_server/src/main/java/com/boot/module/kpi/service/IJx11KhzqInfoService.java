package com.boot.module.kpi.service;

import com.boot.repository.Jx11KhzqInfoPO;
import com.boot.repository.Jx11KhzqInfoVO;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import com.boot.module.sys.service.IBaseService;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * @Description 11绩效考核周期管理 Service
 * @CreateDate 创建时间： 2019-03-04 13:54:40
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface IJx11KhzqInfoService extends IBaseService<Jx11KhzqInfoVO> {

    Jx11KhzqInfoPO findJx11KhzqInfoPOByKhnf(String khnf, String khjdbh);


    List<Jx11KhzqInfoPO> queryByKhnf(String sTime,String eTime);
    /*int  updateYjkssj( String khnf, String khjdbh, String startTime);

    int  updateYjjssj(String khnf, String khjdbh, String endTime);*/
    String getMaxKhnf();

    List<Jx11KhzqInfoPO> queryByMaxKhnf();
}