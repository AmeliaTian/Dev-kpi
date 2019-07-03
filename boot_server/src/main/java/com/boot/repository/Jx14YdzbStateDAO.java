package com.boot.repository;

import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description
 * @CreateDate 创建时间： 2019-01-10 14:19:25
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Jx14YdzbStateDAO extends BaseDAO<Jx14YdzbStatePO, String> {

    Jx14YdzbStatePO findByKhdxid(String khdxid);

    @Modifying
    @Query("update Jx14YdzbStatePO t set yxbs='N' where khdxid=?1 and khnf=?2 ")
    int  updateYxbsByid(@Param("khdxid") String khdxid, @Param("khnf") String khnf);

    @Query(value = "SELECT t.THYY from jx14_ydzb_state t where t.KHDXID=:khdxId and t.KHNF=:khnf  ORDER BY t.OPR_CRT_TIME desc",nativeQuery = true)
    String FindThyy(@Param("khdxId") String khdxId, @Param("khnf") String khnf);

    @Query(value = "SELECT t.zt from jx14_ydzb_state t where t.KHDXID=:khdxId and t.KHNF=:khnf  ORDER BY t.OPR_CRT_TIME desc",nativeQuery = true)
    String queryZt(@Param("khdxId") String khdxId, @Param("khnf") String khnf);



}