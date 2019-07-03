package com.boot.repository;

import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description
 * @CreateDate 创建时间： 2019-03-13 11:30:29
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Jx11KhzqInfoDAO extends BaseDAO<Jx11KhzqInfoPO, String> {

    @Query(value = "select * from jx11_khzq_info zq where zq.KHJDBH=:khjdbh and zq.KHNF=:khnf",nativeQuery = true)
    Jx11KhzqInfoPO findJx11KhzqInfoPOByKhnf(@Param("khnf") String khnf,@Param("khjdbh") String khjdbh);


    @Query(value = "select * from jx11_khzq_info t where t.KHNF>=:sTime and t.KHNF<=:eTime order by t.KHNF desc",nativeQuery = true)
    List<Jx11KhzqInfoPO> queryByKhnf(@Param("sTime")String sTime, @Param("eTime")String eTime);

   /* @Modifying
    @Query("update jx11_khzq_info t set t.JDYJKSSJ=str_to_date(?3, '%Y-%m-%d'),updatetime=NOW() where t.KHNF=:khnf and t.KHJDBH=:khjdbh")
    int  updateYjkssj(@Param("khnf") String khnf,
                    @Param("khjdbh") String khjdbh,
                    @Param("starTime") String startTime);*/
    /*@Modifying
    @Query("update jx11_khzq_info t set t.JDYJJSDJ=str_to_date(?3, '%Y-%m-%d'),updatetime=NOW() where t.KHNF=:khnf and t.KHJDBH=:khjdbh")
    int  updateYjjssj(@Param("khnf") String khnf,
                    @Param("khjdbh") String khjdbh,
                    @Param("endTime") String endTime);*/

    @Query(value = "select max(khnf) khnf from jx11_khzq_info t where t.KHJDBH='1'",nativeQuery = true)
    String getMaxKhnf();

    @Query(value="SELECT * FROM jx11_khzq_info T\n" +
            "WHERE T.KHNF = (SELECT IFNULL((SELECT T1.KHNF FROM ( SELECT * FROM jx11_khzq_info WHERE KHJDBH IN ('1', '2', '3', '4', '5') AND KHNF = (SELECT max(khnf) khnf FROM jx11_khzq_info t WHERE KHJDBH = '1')) T1 WHERE T1.JDSJJSSJ IS NULL OR T1.JDSJJSSJ = '' LIMIT 1 ), (SELECT DATE_FORMAT(NOW(), '%Y'))))\n" +
            "ORDER BY T.KHJDBH",nativeQuery = true)
    List<Jx11KhzqInfoPO> queryByMaxKhnf();
}