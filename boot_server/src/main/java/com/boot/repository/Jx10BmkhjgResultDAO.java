package com.boot.repository;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description
 * @CreateDate 创建时间： 2019-05-29 13:45:57
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Jx10BmkhjgResultDAO extends BaseDAO<Jx10BmkhjgResultPO, String> {

    //更新业绩类最终等级得分
    @Modifying
    @Query("update  Jx10BmkhjgResultPO  set  gjyjlzzdf= ?4 where khnf= ?1 and khzq= ?2 and bmid= ?3 ")
    int  updateGjyjldf(String khnf, String khzq, String orgId, BigDecimal gjyjlzzdf);


    //更新最终得分
    @Modifying
    @Query("update Jx10BmkhjgResultPO set  bmkhdf =?4,khxs=?5 where khnf=?1 and khzq=?2 and bmid=?3 ")
    int  updateZzdf(String khnf, String khzq,String orgId, BigDecimal bmkhdf,String khxs);


    //获得关键业绩类得分 总部部门
    @Query(value ="select sum(rt.GJYJLCSDF*rt.QZ/100) GJYJLZZDF from (SELECT a.KHDXID KHDXID,a.GLBMID GLBMID, a.GLBMMC, a.QZ, br.GJYJLCSDF FROM " +
            "( SELECT BMID BMID, max(BMMC) BMMC, max(GJYJLCSDF) GJYJLCSDF FROM jx10_bmkhjg_result WHERE KHNF =:khnf AND KHZQ =:khzq GROUP BY BMID ) br RIGHT JOIN " +
            "( SELECT t.KHDXID KHDXID, t.GLBMID GLBMID, t.GLBMMC, t.QZ FROM jx21_bmgl_info t WHERE t.KHNF = :khnf AND t.KHZQ = :khzq AND t.KHDXID = :orgId) a ON br.BMID = a.GLBMID) rt group by rt.KHDXID",nativeQuery = true)
    BigDecimal getGjyjlzzdf(@Param("khnf") String khnf, @Param("khzq") String khzq, @Param("orgId") String orgId);
    //查询关键业绩类得分 创新公司和路段公司
    @Query(value ="SELECT max(GJYJLCSDF) GJYJLCSDF FROM jx10_bmkhjg_result WHERE KHNF =:khnf AND KHZQ =:khzq AND  BMID=:orgId GROUP BY BMID" ,nativeQuery = true)
    BigDecimal getGjyjlzzdf1(@Param("khnf") String khnf, @Param("khzq") String khzq, @Param("orgId") String orgId);
    //获得最终得分
    @Query(value="select ((a.yjdf*a.yjqz/100)+(b.djdf*b.djqz/100)) zzdf from ((SELECT\n" +
            "\tt.BMID bmid,\n" +
            "\tmax(z.ZBDL) yjzbdl,\n" +
            "\tmax(t.GJYJLZZDF) yjdf,\n" +
            "\tmax(z.QZ) yjqz\n" +
            "FROM\n" +
            "\tjx10_bmkhjg_result t ,\n" +
            "  jx04_zblbqz_info z\n" +
            "WHERE\n" +
            "\tt.khnf = :khnf " +
            "AND t.khzq = :khzq " +
            "AND t.bmid = :orgId " +
            "AND z.KHDXJS = :orgDesc " +
            "AND z.ZBDL='关键业绩类'\n" +
            "GROUP BY t.bmid ) a\n" +
            "JOIN \n" +
            "     (SELECT\n" +
            "\t\t\t\tzr.KHDXID bmid,\n" +
            "\t\t\t\tmax(zr.zbdl) djzbdl,\n" +
            "\t\t\t\tmax(zr.df) djdf,\n" +
            "        max(z.qz) djqz\n" +
            "\t\t\tFROM\n" +
            "\t\t\t\tjx17_zbdl_result zr,\n" +
            "        jx04_zblbqz_info z\n" +
            "\t\t\tWHERE\n" +
            "\t\t\t\tzr.khnf = :khnf" +
            "\t\t\tAND zr.khzq = :khzq" +
            "\t\t\tAND zr.khdxid = :orgId" +
            "\t\t\tAND zr.zbdl = '党建类'\n" +
            "      AND z.ZBDL = '党建类'\n" +
            "AND z.KHDXJS = :orgDesc" +
            "      GROUP BY zr.KHDXID) b on a.bmid=b.bmid )\n",nativeQuery = true)
    BigDecimal getZzdf(@Param("khnf") String khnf, @Param("khzq") String khzq,@Param("orgId") String orgId,@Param("orgDesc") String orgDesc);

   //总部部门获得关联部门得分
    @Query(value = "SELECT khdf" +
            "   from ((SELECT\n" +
            "  t.BMID ,\n" +
            "\tmax(t.GJYJLCSDF) khdf\n" +
            "FROM\n" +
            "\tjx10_bmkhjg_result t\n" +
            "where t.KHNF=:khnf " +
            "and t.KHZQ=:khzq " +
            "group by t.BMID)v\n" +
            "right JOIN (\n" +
            "\tSELECT\n" +
            "\t\tb.GLBMID\n" +
            "\tFROM\n" +
            "\t\tjx21_bmgl_info b\n" +
            "\tWHERE\n" +
            "\t\tb.KHDXID = :orgId  " +
            "and b.khnf=:khnf " +
            "and b.khzq=:khzq  " +
            ") a ON v.BMID = a.GLBMID)",nativeQuery = true)
    List<String> getGlbmDf(@Param("khnf") String khnf, @Param("khzq") String khzq,@Param("orgId") String orgId);

    @Query(value="select t.GLBMID,t.GLBMMC,t.ID,t.KHDXID,t.KHDXMC,t.KHNF,t.KHZQ,t.QZ from  jx21_bmgl_info t where t.KHDXID=:orgId and t.KHNF=:khnf and t.KHZQ=:khzq",nativeQuery = true)
    List<JSONObject> getGlbm(@Param("khnf") String khnf, @Param("khzq") String khzq, @Param("orgId") String orgId);

    @Query(value = "select  max(t.BMKHDF) from  jx10_bmkhjg_result t where t.BMID =:orgId and t.KHNF=:khnf and t.KHZQ='半年度' GROUP BY t.BMID",nativeQuery = true)
    BigDecimal getBndDf(@Param("khnf") String khnf,@Param("orgId") String orgId);


    //更新预算人数
    @Modifying
    @Query("update  Jx10BmkhjgResultPO  set  ysrs= ?5 where khnf= ?1 and khzq= ?2 and bmid= ?3 and djmc=?4")
    int updateYsrs(String khnf, String khzq, String bmid, String djmc, String ysrs);

    //根据部门名称 考核年份 考核周期 查询最终成绩
    @Query(value="select * from jx10_bmkhjg_result t where t.BMMC=:orgName and t.KHNF=:khnf and t.KHZQ=:khzq",nativeQuery = true)
    List<Jx10BmkhjgResultPO> getZzcj(@Param("khnf") String khnf, @Param("khzq") String khzq, @Param("orgName") String orgName);

}