package com.boot.module.kpi.service;

import com.boot.repository.Jx12KhztrwInfoPO;
import com.boot.repository.Jx12KhztrwInfoVO;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import com.boot.module.sys.service.IBaseService;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description 12考核主体任务表 Service
 * @CreateDate 创建时间： 2019-02-14 16:11:13
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface IJx12KhztrwInfoService extends IBaseService<Jx12KhztrwInfoVO> {
   List<String> getJx12ByKhdxIdAndKhnf( String khdxid, String khnf,String khzq,String[] zblb);
   List<String> getJx12ByKhdxIdAndKhnf( String khdxid, String khnf,String khzq);
   /* int  updateYxbsByid(String id,String khztId,String khztName,String khztQz);*/
   /*void addRws();*/
   List<Jx12KhztrwInfoPO> queryAll(String khzq,String khnf );
   int  updateDf(String khdf,String khdxid,String khztid,String khnf,String khzq,String zblx);
   List<String> getId( String khdxid,String khnf,String khzq,String[] zblb,String khztid);


}