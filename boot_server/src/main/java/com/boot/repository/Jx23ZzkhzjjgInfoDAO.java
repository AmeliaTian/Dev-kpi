package com.boot.repository;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description
 * @CreateDate 创建时间： 2019-06-20 11:47:03
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Jx23ZzkhzjjgInfoDAO extends BaseDAO<Jx23ZzkhzjjgInfoPO, String> {

    //查询组织的考核成绩
    @Query(value = "select sum(t.KHDF*t.KHZTQZ/100) BNDDF,max(t.KHDXMC) KHDXMC  from jx23_zzkhzjjg_info t where t.KHNF=:khnf and t.KHZQ=:khzq and t.KHDXID=:khdxid GROUP BY t.KHDXID",nativeQuery = true)
    JSONObject getBnddf(@Param("khnf")String khnf, @Param("khzq")String khzq, @Param("khdxid")String khdxid);


    @Query(value = "select * from jx23_zzkhzjjg_info where KHZTID=:khztid and KHNF=:khnf and KHZQ=:khzq and KHDXID=:khdxid",nativeQuery = true)
    Jx23ZzkhzjjgInfoPO findBy(@Param("khztid") String khztid,  @Param("khzq") String khzq,@Param("khnf") String khnf, @Param("khdxid")String khdxid);

    @Query(value="SELECT\n" +
            "\tDISTINCT t.KHDF KHDF\n" +
            "FROM\n" +
            "\tjx23_zzkhzjjg_info t\n" +
            "RIGHT JOIN \n" +
            "jx12_khztrw_info k \n" +
            "ON k.KHZTID = t.KHZTID\n" +
            "and k.KHDXID = t.KHDXID\n" +
            "WHERE\n" +
            "\t  k.KHNF = :khnf " +
            "AND k.KHZQ = :khzq " +
            "AND k.KHDXID = :khdxid ",nativeQuery = true)
    List<String> getKhztDfs(@Param("khnf")String khnf, @Param("khzq")String khzq, @Param("khdxid")String khdxid);
}