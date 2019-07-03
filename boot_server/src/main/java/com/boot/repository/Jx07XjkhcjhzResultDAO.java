package com.boot.repository;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2019-03-04 11:17:20
 * @ModifiedBy
 * @ModifiedDate
 */
public interface Jx07XjkhcjhzResultDAO extends BaseDAO<Jx07XjkhcjhzResultPO, String> {

    @Query(value = "SELECT t.BMMC,t.BZ,t.ID,t.JXJF,t.KEDJTZR,t.KHDF,t.KHDJ,t.KHDXID,t.KHDXLB,t.KHDXMC,t.KHNF,t.KHXS,t.KHZQ,t.KHDXJS, t.KHDXJSID,t.OPR_CRT_TIME,t.SFTX,t.UPDATETIME,t.YXBS,t.ZZDJ from jx07_xjkhcjhz_result t where t.KHDXID=:khdxid  and t.KHNF=:khnf", nativeQuery = true)
    List<Jx07XjkhcjhzResultPO> findByKhdxid1(@Param("khdxid") String khdxid, @Param("khnf") String khnf);

    @Query(value = "SELECT t.JXJF,t.KHDF,t.KHNF,t.KHXS,t.KHZQ,t.SFTX,t.ZZDJ from jx07_xjkhcjhz_result t where t.KHDXID=:khdxid  and t.KHNF=:khnf and t.KHZQ=:khzq", nativeQuery = true)
    JSONObject getByKhdxid(@Param("khdxid") String khdxid, @Param("khnf") String khnf, @Param("khzq") String khzq);

    //根据考核年份和考核周期查询所有的考核结果 员工
    @Query(value = "SELECT t.ID,t.KHDXID,t.KHDXMC,t.KHDXLB,t.KHDXJS,t.BMMC,t.KHNF,t.KHZQ,t.KHDF,t.KHXS,t.KHDJ,t.ZZDJ,t.JXJF,t.SFTX from jx07_xjkhcjhz_result t where t.khnf=:khnf and t.KHZQ=:khzq and t.KHDXJS='员工'  ORDER BY t.BMMC", nativeQuery = true)
    List<JSONObject> queryKhjg(@Param("khnf") String khnf, @Param("khzq") String khzq);

    //根据考核年份和考核周期和用户所在部门查询所有的考核结果 员工
    @Query(value = "SELECT t.ID,t.KHDXID,t.KHDXMC,t.KHDXLB,t.KHDXJS,t.BMMC,t.KHNF,t.KHZQ,t.KHDF,t.KHXS,t.KHDJ,t.ZZDJ,t.JXJF,t.SFTX from jx07_xjkhcjhz_result t where t.khnf=:khnf and t.KHZQ=:khzq and t.KHDXJS='员工' and t.BMMC in (select o.ORG_NAME from au02_organization o where o.id in (select uo.ORG_ID from au12_org_user uo where uo.user_id=:userId)) ORDER BY t.BMMC", nativeQuery = true)
    List<JSONObject> queryKhjg(@Param("khnf") String khnf, @Param("khzq") String khzq, @Param("userId") String userId);

    //根据考核对象id和考核年份 查询近3年的考核成绩
    @Query(value = "SELECT t.BMMC,t.BZ,t.ID,t.JXJF,t.KEDJTZR,t.KHDF,t.KHDJ,t.KHDXID,t.KHDXLB,t.KHDXMC,t.KHNF,t.KHXS,t.KHZQ,t.OPR_CRT_TIME,t.SFTX,t.UPDATETIME,t.YXBS,t.ZZDJ from jx07_xjkhcjhz_result t where t.KHDXID=:khdxid  and t.KHNF >=(:khnf-2) and t.KHNF <=:khnf order by t.KHNF,t.KHZQ", nativeQuery = true)
    List<JSONObject> queryByKhdxId(@Param("khdxid") String khdxid, @Param("khnf") String khnf);

    //查询所有中层的考核结果
    @Query(value = "SELECT t.ID,t.KHDXID,t.KHDXMC,t.KHDXLB,t.KHDXJS,t.BMMC,t.KHNF,t.KHZQ,t.KHDF,t.KHXS,t.KHDJ,t.ZZDJ,t.JXJF,t.SFTX from jx07_xjkhcjhz_result t where t.khnf=:khnf and t.KHZQ=:khzq and t.KHDXJS in ('总部部门正职','总部部门副职','所属公司正职','所属公司副职')  ORDER BY t.BMMC", nativeQuery = true)
    List<JSONObject> queryKhjgZc(@Param("khnf") String khnf, @Param("khzq") String khzq);

    //根据部门名称查询等级分布饼状图
    @Query(value = "SELECT t2.khdj khdj, ifnull(t1.count1, 0) count FROM ( ( SELECT t.ZZDJ ZZDJ, count(*) count1 FROM jx07_xjkhcjhz_result t WHERE t.KHNF=:khnf AND t.KHZQ=:khzq AND t.BMMC=:bmmc AND t.KHDXJS='员工' GROUP BY t.ZZDJ) t1 RIGHT JOIN ( SELECT DISTINCT(khdj) FROM jx13_khdjgj_info GROUP BY khdj ORDER BY FIELD('卓越','优秀','称职','待改进','不合格')) t2 ON t1.ZZDJ = t2.khdj )", nativeQuery = true)
    List<JSONObject> queryDjCount(@Param("khnf") String khnf, @Param("khzq") String khzq, @Param("bmmc") String bmmc);

    //查询全部员工等级分布饼状图
    @Query(value = "SELECT t2.khdj khdj, ifnull(t1.count1, 0) count FROM ( ( SELECT t.ZZDJ ZZDJ, count(*) count1 FROM jx07_xjkhcjhz_result t WHERE t.KHNF=:khnf AND t.KHZQ=:khzq AND t.KHDXJS='员工' GROUP BY t.ZZDJ) t1 RIGHT JOIN ( SELECT DISTINCT(khdj) FROM jx13_khdjgj_info GROUP BY khdj ORDER BY FIELD('卓越','优秀','称职','待改进','不合格')) t2 ON t1.ZZDJ = t2.khdj )", nativeQuery = true)
    List<JSONObject> queryDjCount(@Param("khnf") String khnf, @Param("khzq") String khzq);


    //根据部门名称查询考核得分分布柱状图
    @Query(value = "select count(case when t.KHDF >= 100 then '100以上' end) as '100以上' ,count(case when t.KHDF > 89 and t.KHDF < 100 then '90-99' end )as '90-99'," +
            "        count(case when t.KHDF > 79 and t.KHDF < 90 then '80-89'end )as '80-89',count(case when t.KHDF > 69 and t.KHDF < 80 then '70-79' end )as '70-79'," +
            "count(case when t.KHDF <=69 then '0-69' end )as '0-69', AVG(t.khdf) as pjf from jx07_xjkhcjhz_result t  WHERE t.KHNF=:khnf and t.KHZQ=:khzq and t.BMMC=:bmmc AND t.KHDXJS='员工'", nativeQuery = true)
    List<JSONObject> queryFsCount(@Param("khnf") String khnf, @Param("khzq") String khzq, @Param("bmmc") String bmmc);

    //查询全部员工考核得分分布柱状图
    @Query(value = "select count(case when t.KHDF >= 100 then '100以上' end) as '100以上' ,count(case when t.KHDF > 89 and t.KHDF < 100 then '90-99' end )as '90-99'," +
            "                   count(case when t.KHDF > 79 and t.KHDF < 90 then '80-89'end )as '80-89',count(case when t.KHDF > 69 and t.KHDF < 80 then '70-79' end )as '70-79'," +
            "            count(case when t.KHDF <=69 then '0-69' end )as '0-69', AVG(t.khdf) as pjf from jx07_xjkhcjhz_result t  WHERE t.KHNF=:khnf and t.KHZQ=:khzq  AND t.KHDXJS='员工'", nativeQuery = true)
    List<JSONObject> queryFsCount(@Param("khnf") String khnf, @Param("khzq") String khzq);

    //查询部门所有员工的得分  根据员工id查询
    @Query(value = "SELECT t.KHDF,t.ZZDJ FROM jx07_xjkhcjhz_result t RIGHT JOIN ( SELECT DISTINCT j12.KHDXID, j12.KHNF, j12.KHZQ FROM jx12_khztrw_info j12 WHERE j12.KHNF =:khnf AND j12.KHZQ =:khzq  AND j12.KHDXID IN " +
            "(SELECT v2.USER_ID FROM va02_user_orgs_roles v1 JOIN va02_user_orgs_roles v2 ON v2.ORG_ID = v1.ORG_ID WHERE v1.USER_ID =:khdxid AND v2.ROLE_ID = '42CBTEE0P8N4')) a ON a.KHDXID = t.KHDXID AND a.KHNF = t.KHNF AND a.KHZQ = t.KHZQ",nativeQuery = true)
    List<JSONObject> getAllYgDf(@Param("khnf") String khnf, @Param("khzq") String khzq,@Param("khdxid") String khdxid);

    //查询部门所有员工的得分  根据部门id查询
    @Query(value = "SELECT t.KHDF,t.ZZDJ FROM jx07_xjkhcjhz_result t RIGHT JOIN ( SELECT DISTINCT j12.KHDXID, j12.KHNF, j12.KHZQ FROM jx12_khztrw_info j12 WHERE j12.KHNF =:khnf AND j12.KHZQ =:khzq  AND j12.KHDXID IN " +
            "(SELECT v2.USER_ID FROM va02_user_orgs_roles v1 JOIN va02_user_orgs_roles v2 ON v2.ORG_ID = v1.ORG_ID WHERE v1.ORG_ID =:orgId AND v2.ROLE_ID = '42CBTEE0P8N4')) a ON a.KHDXID = t.KHDXID AND a.KHNF = t.KHNF AND a.KHZQ = t.KHZQ",nativeQuery = true)
    List<JSONObject> getAllYgDf1(@Param("khnf") String khnf, @Param("khzq") String khzq,@Param("orgId") String orgId);

    //查询部门所有员工的得分信息
    @Query(value = "select * from jx07_xjkhcjhz_result where KHNF=?1 AND KHZQ=?2 and BMMC=?3 and KHDXJS='员工' order by KHDF+0 DESC",nativeQuery = true)
    List<Jx07XjkhcjhzResultPO> findByBmmc(String khnf, String khzq, String bmmc);
}