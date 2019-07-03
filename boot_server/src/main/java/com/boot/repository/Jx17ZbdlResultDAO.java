package com.boot.repository;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description
 * @CreateDate 创建时间： 2019-05-29 13:47:02
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Jx17ZbdlResultDAO extends BaseDAO<Jx17ZbdlResultPO, String> {




    @Query(value="select max(t.KHDXMC)BMMC,max(t.KHDXJSID) KHDXJSID,sum(t.DF) GJYJLCSDF from jx17_zbdl_result t where t.KHNF=:khnf and t.KHZQ=:khzq and t.KHDXID=:khdxid  and t.ZBDL<>'党建类' GROUP BY t.KHDXID ",nativeQuery = true)
    JSONObject queryGjyjjg(@Param("khdxid") String khdxid, @Param("khnf") String khnf, @Param("khzq")String khzq);



    //获取员工的总得分
    @Query(value="SELECT\n" +
            "\tsum(t.QZ*a.DF/100) zzdf\n" +
            "FROM\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "      zr.KHDXJSID,\n" +
            "      zr.ZBDL,\n" +
            "\t\t\tzr.DF\n" +
            "\t\tFROM\n" +
            "\t\t\tjx17_zbdl_result zr\n" +
            "\t\tWHERE\n" +
            "\t\t\tzr.KHDXID = :khdxid     " +
            "\t\tAND KHNF = :khnf " +
            "\t\tAND KHZQ = :khzq" +
            "\t) a\n" +
            "LEFT JOIN (\n" +
            "\tSELECT\n" +
            "\t\tZBDL,\n" +
            "\t\tQZ,\n" +
            "\t\tKHDXJS\n" +
            "\tFROM\n" +
            "\t\tjx04_zblbqz_info\n" +
            ") t ON a.KHDXJSID = t.khdxjs \n" +
            "and a.ZBDL=t.ZBDL",nativeQuery = true)
    String getYgDf(@Param("khdxid") String khdxid, @Param("khnf") String khnf, @Param("khzq")String khzq);


    @Query(value = "SELECT\n" +
            "\t(\n" +
            "\t\t(a.yjdf * a.yjqz / 100) + (b.djdf * b.djqz / 100)\n" +
            "\t) zzdf\n" +
            "FROM\n" +
            "\t(\n" +
            "\t\t(\n" +
            "\t\t\tSELECT\n" +
            "\t\t\t\tt.BMID bmid,\n" +
            "\t\t\t\tmax(z.ZBDL) yjzbdl,\n" +
            "\t\t\t\tmax(t.BMKHDF) yjdf,\n" +
            "\t\t\t\tmax(z.QZ) yjqz\n" +
            "\t\t\tFROM\n" +
            "\t\t\t\tjx10_bmkhjg_result t,\n" +
            "\t\t\t\tjx04_zblbqz_info z\n" +
            "\t\t\tWHERE\n" +
            "\t\t\t\tt.khnf = :khnf " +
            "\t\t\tAND t.khzq = :khzq  " +
            "\t\t\tAND t.BMMC = :bmmc " +
            "\t\t\tAND z.KHDXJS = :khdxjs " +
            "\t\t\tAND z.ZBDL = '关键业绩类'\n" +
            "\t\t\tGROUP BY\n" +
            "\t\t\t\tt.bmid\n" +
            "\t\t) a\n" +
            "\t\tJOIN (\n" +
            "\t\t\tSELECT\n" +
            "\t\t\t\tzr.KHDXID bmid,\n" +
            "\t\t\t\tmax(zr.zbdl) djzbdl,\n" +
            "\t\t\t\tmax(zr.df) djdf,\n" +
            "\t\t\t\tmax(z.qz) djqz\n" +
            "\t\t\tFROM\n" +
            "\t\t\t\tjx17_zbdl_result zr,\n" +
            "\t\t\t\tjx04_zblbqz_info z\n" +
            "\t\t\tWHERE\n" +
            "\t\t\t\tzr.khnf = :khnf" +
            "\t\t\tAND zr.khzq = :khzq" +
            "\t\t\tAND zr.khdxid = :khdxid" +
            "\t\t\tAND zr.zbdl = '胜任力'\n" +
            "\t\t\tAND z.ZBDL = '胜任力'\n" +
            "\t\t\tAND z.KHDXJS = :khdxjs " +
            "\t\t\tGROUP BY\n" +
            "\t\t\t\tzr.KHDXID\n" +
            "\t\t) b \n" +
            "\t)",nativeQuery = true)
    String getZcNdDf(@Param("khdxid") String khdxid, @Param("khnf") String khnf, @Param("khzq")String khzq,@Param("khdxjs")String khdxjs,@Param("bmmc")String bmmc);



    @Query(value = "select * from  jx17_zbdl_result t where t.KHDXID=:khdxid and t.KHNF=:khnf and t.KHZQ=:khzq and t.ZBDL='党建类'",nativeQuery = true)
    JSONObject getDjInfo(@Param("khdxid") String khdxid, @Param("khnf") String khnf, @Param("khzq")String khzq);




}