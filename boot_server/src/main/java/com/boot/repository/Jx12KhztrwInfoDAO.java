package com.boot.repository;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @CreateDate 创建时间： 2019-02-14 16:11:13
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Jx12KhztrwInfoDAO extends BaseDAO<Jx12KhztrwInfoPO, String> {

    /*@Transactional
    @Modifying
    @Query("update Jx12KhztrwInfoPO t set khzt=?3,khztid=?2,updatetime=NOW(),khztqz=?4 where id=?1 ")
    int  updateYxbsByid(@Param("id") String id,
                        @Param("khztId") String khztId,
                        @Param("khztName") String khztName,
                        @Param("khztQz") String khztQz);*/

    @Transactional
    @Modifying
    @Query("update Jx12KhztrwInfoPO t set t.khdf=?1 where t.khdxid=?2 and t.khztid=?3 and t.khnf=?4 and t.khzq=?5 and t.zblx=?6")
    int  updateDf(@Param("khdf") String khdf,
                  @Param("khdxid") String khdxid,
                  @Param("khztid") String khztid,
                  @Param("khnf") String khnf,
                  @Param("khzq") String khzq,
                  @Param("zblx") String zblx);

    @Query(value="select id  from jx12_khztrw_info where khdxid=:khdxid and khnf=:khnf and khzq=:khzq and zblx in (:zblb)", nativeQuery = true)
    List<String> getJx12ByKhdxIdAndKhnf(@Param("khdxid") String khdxid, @Param("khnf") String khnf,@Param("khzq")String khzq,@Param("zblb") String[] zblb);


    @Query(value="select id  from jx12_khztrw_info where khdxid=:khdxid and khnf=:khnf and khzq=:khzq and zblx in (:zblb) and khztid=:khztid and khlx='绩效'", nativeQuery = true)
    List<String> getId(@Param("khdxid") String khdxid, @Param("khnf") String khnf,@Param("khzq")String khzq,@Param("zblb") String[] zblb,@Param("khztid") String khztid);


    @Query(value="select id  from jx12_khztrw_info where khdxid=:khdxid and khnf=:khnf and khzq=:khzq ", nativeQuery = true)
    List<String> getJx12ByKhdxIdAndKhnf(@Param("khdxid") String khdxid, @Param("khnf") String khnf,@Param("khzq")String khzq);

    @Query(value="select a.*,u.user_name_cn from(SELECT t.KHDXJSID,t.KHDXJS,t.QZ,t.ZBDL,t.KHZTJS,t.KHZTJSID,t.bz,ur.USER_ID FROM jx05_khztqz_info t LEFT JOIN au11_user_role ur ON t.KHDXJSID = ur.role_id " +
            "WHERE t.KHZTJSID = :khztjsid )a LEFT JOIN au01_user u on a.user_id=u.id",nativeQuery = true)
    List getKhdxInfo(@Param("khztjsid") String khztjsid);

    @Query(value = "SELECT\n" +
            "\ta.*, b.USER_NAME_CN\n" +
            "FROM\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tt.KHDXJSID,\n" +
            "\t\t\tt.KHDXJS,\n" +
            "\t\t\tt.QZ,\n" +
            "\t\t\tt.ZBDL,\n" +
            "\t\t\tt.KHZTJS,\n" +
            "\t\t\tt.KHZTJSID,\n" +
            "\t\t\tt.bz,\n" +
            "\t\t\tur.USER_ID\n" +
            "\t\tFROM\n" +
            "\t\t\tjx05_khztqz_info t\n" +
            "\t\tLEFT JOIN au11_user_role ur ON t.KHDXJSID = ur.role_id\n" +
            "\t\tWHERE\n" +
            "\t\t\tt.KHZTJSID = :khztjsid\n" +
            "\t) a\n" +
            "JOIN (\n" +
            "\tSELECT\n" +
            "\t\tt1.ORG_NAME,\n" +
            "\t\tt1.ORG_DESC,\n" +
            "\t\tt1.ORG_LEADER,\n" +
            "\t\tt1.ID,\n" +
            "\t\tt1.USER_ID,\n" +
            "\t\tu.USER_NAME_CN\n" +
            "\tFROM\n" +
            "\t\t(\n" +
            "\t\t\tSELECT\n" +
            "\t\t\t\to.ORG_NAME,\n" +
            "\t\t\t\to.ORG_DESC,\n" +
            "\t\t\t\to.ORG_LEADER,\n" +
            "\t\t\t\to.ID,\n" +
            "\t\t\t\tou.USER_ID\n" +
            "\t\t\tFROM\n" +
            "\t\t\t\tau02_organization o\n" +
            "\t\t\tLEFT JOIN au12_org_user ou ON o.ID = ou.ORG_ID\n" +
            "\t\t\tWHERE\n" +
            "\t\t\t\to.org_leader = :leaderId\n" +
            "\t\t) t1\n" +
            "\tLEFT JOIN au01_user u ON t1.user_id = u.id\n" +
            ") b ON a.USER_ID = b.user_id",nativeQuery = true)
    List getFgKhdxInfo(@Param("khztjsid") String khztjsid,@Param("leaderId") String leaderId);

   @Query(value = "SELECT\n" +
           "\tdistinct a.*, b.USER_NAME_CN,b.DIRECT_SUPERIOR,b.ROLE_ID,b.ROLE_NAME\n" +
           "FROM\n" +
           "\t(\n" +
           "\t\tSELECT\n" +
           "\t\t\tt.KHDXJSID,\n" +
           "\t\t\tt.KHDXJS,\n" +
           "\t\t\tt.ZBDL,\n" +
           "\t\t\tt.KHZTJS,\n" +
           "\t\t\tt.KHZTJSID,\n" +
           "\t\t\tur.USER_ID\n" +
           "\t\tFROM\n" +
           "\t\t\tjx05_khztqz_info t\n" +
           "\t\tLEFT JOIN au11_user_role ur ON t.KHDXJSID = ur.role_id WHERE t.KHZTJSID = :khztjsid\n" +
           "\t) a\n" +
           "JOIN (\n" +
           "\tSELECT\n" +
           "\t\tu.ID,\n" +
           "\t\tu.USER_NAME_CN,\n" +
           "\t\tu.DIRECT_SUPERIOR,\n" +
           "\t\tur.ROLE_ID,\n" +
           "\t\tr.ROLE_NAME\n" +
           "\tFROM\n" +
           "\t\t(\n" +
           "\t\t\tSELECT\n" +
           "\t\t\t\t*\n" +
           "\t\t\tFROM\n" +
           "\t\t\t\tau12_org_user ou1\n" +
           "\t\t\tWHERE\n" +
           "\t\t\t\tou1.org_id = (\n" +
           "\t\t\t\t\tSELECT\n" +
           "\t\t\t\t\t\torg_id\n" +
           "\t\t\t\t\tFROM\n" +
           "\t\t\t\t\t\tau12_org_user ou\n" +
           "\t\t\t\t\tWHERE\n" +
           "\t\t\t\t\t\tou.USER_ID = :userid\n" +
           "\t\t\t\t)\n" +
           "\t\t) t1\n" +
           "\tLEFT JOIN au01_user u ON t1.user_id = u.id\n" +
           "  LEFT JOIN au11_user_role ur on u.ID=ur.USER_ID\n" +
           "\tLEFT JOIN au03_role r on ur.ROLE_ID=r.ID\n" +
           ") b ON a.USER_ID = b.id\n",nativeQuery =true)
    List getZhKhdxInfo (@Param("khztjsid") String khztjsid,@Param("userid") String userid);

    @Query(value = "SELECT a.*, b.USER_NAME_CN FROM ( SELECT t.KHDXJSID,t.KHDXJS,t.QZ,t.ZBDL,t.KHZTJS,t.KHZTJSID,t.bz,ur.USER_ID FROM jx05_khztqz_info t LEFT JOIN au11_user_role ur ON t.KHDXJSID = ur.role_id WHERE t.KHZTJSID = :khztjsid " +
            ") a JOIN ( SELECT u.ID,u.USER_NAME_CN from au01_user u where u.DIRECT_SUPERIOR=:userid ) b ON a.USER_ID = b.id  ",nativeQuery =true)
    List getFzKhdxInfo (@Param("khztjsid") String khztjsid,@Param("userid") String userid);

    @Query(value="select * from jx12_khztrw_info t where t.KHDXID=:khdxid and t.KHZTID=:khztid and t.KHNF=:khnf",nativeQuery = true)
    List<Jx12KhztrwInfoPO> getByKhztId(@Param("khdxid") String khdxid,@Param("khztid") String khztid,@Param("khnf") String khnf);


    @Query(value="select a.*,o.ORG_NAME from ((select t.*,ou1.ORG_ID from  jx12_khztrw_info t \n" +
            "LEFT JOIN au12_org_user ou1 on t.KHDXID=ou1.user_id\n" +
            "where t.KHZTID=:khztid and t.KHNF=:khnf) a LEFT JOIN au02_organization o on a.org_id=o.id)",nativeQuery = true)
    List getByKhztIdAndKhnf(@Param("khztid") String khztid,@Param("khnf") String khnf);

    @Query(value = "SELECT * from jx12_khztrw_info t where t.KHNF=:khnf and t.KHZQ=:khzq and t.KHLX='绩效' and t.KHDXID=:khdxid",nativeQuery = true)
    List<Jx12KhztrwInfoPO> queryByKhdxid(@Param("khdxid")String khdxid,@Param("khnf") String khnf,@Param("khzq")String khzq);

    @Query(value = "SELECT * from jx12_khztrw_info t where t.khnf=:khnf and t.khzq=:khzq order by t.KHDXJS ,t.KHDX,t.KHZT, t.OPR_CRT_TIME DESC",nativeQuery = true)
    List<Jx12KhztrwInfoPO> queryAll(@Param("khzq")String khzq,@Param("khnf") String khnf);


    //查询考核对象为中层的
    @Query(value = "SELECT  t.*, a.ORG_NAME, a.ID AS ORG_ID FROM (SELECT max(t.KHNF) KHNF, max(t.KHZQ) KHZQ,max(t.KHLX) KHLX, MAX(t.ZBLX) ZBLX, t.KHDXID,t.KHDX,t.KHDXJS,max(t.KHZTQZ) KHZTQZ,t.KHDF  FROM  jx12_khztrw_info t  WHERE t.KHZTID =:khztid AND t.KHNF =:khnf  AND t.KHZQ =:khzq   AND t.KHLX = '绩效' AND t.ZBLX in (:zblx) GROUP BY t.KHDXID,t.KHDX,t.KHDXJS,t.KHDF ORDER BY t.KHDXJS,t.KHDX) t JOIN ( SELECT  o.ID, o.ORG_NAME, uo.USER_ID  FROM  au02_organization o   JOIN (SELECT ORG_ID, USER_ID  FROM  au12_org_user  WHERE ORG_ID=:orgid ) uo ON o.ID = uo.ORG_ID  ) a ON t.KHDXID = a.USER_ID",nativeQuery = true)
    List<JSONObject> queryKhdx(@Param("khztid") String khztid,@Param("khnf") String khnf,@Param("khzq") String khzq,@Param("orgid")String orgid,@Param("zblx") String[] zblx);


    //查询考核对象为员工的
    @Query(value = "SELECT  t.*, a.ORG_NAME, a.ID AS ORG_ID FROM (SELECT max(t.KHNF) KHNF, max(t.KHZQ) KHZQ,max(t.KHLX) KHLX,  t.KHDXID,t.KHDX,t.KHDXJS,max(t.KHDF) KHDF  FROM  jx12_khztrw_info t  WHERE t.KHZTID =:khztid AND t.KHNF =:khnf  AND t.KHZQ =:khzq   AND t.KHLX = '绩效' AND t.ZBLX in (:zblx) GROUP BY t.KHDXID,t.KHDX,t.KHDXJS ORDER BY t.KHDXJS,t.KHDX) t JOIN ( SELECT  o.ID, o.ORG_NAME, uo.USER_ID  FROM  au02_organization o   JOIN (SELECT ORG_ID, USER_ID  FROM  au12_org_user  WHERE ORG_ID=:orgid ) uo ON o.ID = uo.ORG_ID  ) a ON t.KHDXID = a.USER_ID",nativeQuery = true)
    List<JSONObject> queryYgKhdx(@Param("khztid") String khztid,@Param("khnf") String khnf,@Param("khzq") String khzq,@Param("orgid")String orgid,@Param("zblx") String[] zblx);
    //@Query(value = "SELECT  t.*, a.ORG_NAME, a.ID AS ORG_ID FROM (SELECT max(t.KHNF) KHNF, max(t.KHZQ) KHZQ,max(t.KHLX) KHLX,  t.KHDXID,t.KHDX,t.KHDXJS  FROM  jx12_khztrw_info t  WHERE t.KHZTID =:khztid AND t.KHNF =:khnf  AND t.KHZQ =:khzq   AND t.KHLX = '绩效' AND t.ZBLX in (:zblx) GROUP BY t.KHDXID,t.KHDX,t.KHDXJS ORDER BY t.KHDXJS,t.KHDX) t JOIN ( SELECT  o.ID, o.ORG_NAME, uo.USER_ID  FROM  au02_organization o   JOIN (SELECT ORG_ID, USER_ID  FROM  au12_org_user  WHERE ORG_ID=:orgid ) uo ON o.ID = uo.ORG_ID  ) a ON t.KHDXID = a.USER_ID",nativeQuery = true)
    //List<JSONObject> queryYgKhdx(@Param("khztid") String khztid,@Param("khnf") String khnf,@Param("khzq") String khzq,@Param("orgid")String orgid,@Param("zblx") String[] zblx);
    //查询考核对象为组织的
    @Query(value = "SELECT max(t.KHNF) KHNF, max(t.KHZQ) KHZQ,max(t.KHLX) KHLX,t.KHDXID,t.KHDX,t.KHDXJS    FROM  jx12_khztrw_info t  WHERE t.KHZTID =:khztid AND t.KHNF =:khnf  AND t.KHZQ =:khzq   AND t.KHLX = '绩效' AND t.ZBLX in (:zblx) GROUP BY t.KHDXID,t.KHDX,t.KHDXJS ORDER BY FIELD(t.KHDXJS,'总部部门','路段公司','创新公司')," +
            "FIELD(t.KHDX,'行政部','党委宣传部','人力资源部','党委办公室','财务部','企业管理部','投资开发部','战略发展部','学会','创新研究院','资本运营部','董事会办公室','安全管理部','风险管理部','监察部','工会','总经理助理'," +
            "'京津塘高速','贵黄公司','甬台温高速','北仑港高速','九瑞高速','桂林公司','鄂东大桥','重庆公司','亳阜高速','华祺投资','招商新智','路宇公司')",nativeQuery = true)
    List<JSONObject> queryYgKhdx(@Param("khztid") String khztid,@Param("khnf") String khnf,@Param("khzq") String khzq,@Param("zblx") String[] zblx);

    //@Query(value="SELECT t.ZBLX,t.KHZTQZ,t.KHDF FROM jx12_khztrw_info t WHERE t.KHDXID =:khdxid AND t.KHNF =:khnf AND t.KHZQ =:khzq AND t.KHZTID =:khztid AND t.KHLX = '绩效' ORDER BY t.KHDXJS,t.KHDX",nativeQuery = true)
    //List<JSONObject> queryZblxAndQz(@Param("khdxid") String khdxid,@Param("khnf") String khnf,@Param("khzq") String khzq,@Param("khztid") String khztid);

    @Query(value="SELECT t.ID,t.ZBLX,t.KHZTQZ,t.KHDF FROM jx12_khztrw_info t WHERE t.KHDXID =:khdxid AND t.KHNF =:khnf AND t.KHZQ =:khzq AND t.KHZTID =:khztid AND t.KHLX = '绩效' ORDER BY t.KHDXJS,t.KHDX,FIELD(t.ZBLX,'业绩类', '基础类', '财务类', '营运类','管理类', '任务类', '创新类', '加分类', '重要信息','党建类','关键业绩类','态度类')",nativeQuery = true)
    List<JSONObject> queryZblxAndQz(@Param("khdxid") String khdxid,@Param("khnf") String khnf,@Param("khzq") String khzq,@Param("khztid") String khztid);


    //根据考核对象id 考核年份 考核周期 考核类型查询所有的考核得分
    @Query(value="select khdf from jx12_khztrw_info where khdxid=:khdxid and khnf=:khnf and khzq=:khzq and khlx='绩效'" ,nativeQuery = true)
    List<String> queryDf(@Param("khdxid") String khdxid, @Param("khnf") String khnf,@Param("khzq")String khzq);

    //根据考核对象id 考核年份 考核周期 考核类型 计算指标大类的得分
    @Query(value = "SELECT max(a.KHDX) KHDX, max(a.KHDXJS) KHDXJS, a.ZBLX ZBLX, sum(a.QZDF) ZBDLDF FROM ( SELECT max(t.KHDXID) KHDXID, max(t.KHDX) KHDX, max(t.KHDXJS) KHDXJS, t.ZBLX, t.KHZT, (t.KHDF * t.KHZTQZ / 100) QZDF FROM jx12_khztrw_info t WHERE t.khnf = :khnf AND t.khzq = :khzq AND t.khdxid = :khdxid AND  t.khlx='绩效' GROUP BY t.ZBLX, t.khzt, (t.KHDF * t.KHZTQZ / 100) ) a GROUP BY a.ZBLX",nativeQuery = true)
    List<JSONObject> queryZbdlDf(@Param("khdxid") String khdxid, @Param("khnf") String khnf,@Param("khzq")String khzq);

    //查询中层胜任力得分
    @Query(value="SELECT\n" +
            "\tmax(b.KHDX) KHDX,\n" +
            "\tmax(b.KHDXJS) KHDXJS,\n" +
            "\tb.ZBLX ZBLX,\n" +
            "\tsum(b.ZBDLDF) ZBDLDF\n" +
            "FROM\n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\tmax(a.KHDX) KHDX,\n" +
            "\t\t\tmax(a.KHDXJS) KHDXJS,\n" +
            "\t\t\ta.ZBLX ZBLX,\n" +
            "\t\t\ta.KHZTJS,\n" +
            "\t\t\tavg(a.QZDF) ZBDLDF\n" +
            "\t\tFROM\n" +
            "\t\t\t(\n" +
            "\t\t\t\tSELECT\n" +
            "\t\t\t\t\tmax(t.KHDXID) KHDXID,\n" +
            "\t\t\t\t\tmax(t.KHDX) KHDX,\n" +
            "\t\t\t\t\tmax(t.KHDXJS) KHDXJS,\n" +
            "\t\t\t\t\tt.ZBLX,\n" +
            "\t\t\t\t\tt.KHZTJS,\n" +
            "\t\t\t\t\tt.KHZT,\n" +
            "\t\t\t\t\tavg(t.KHDF * t.KHZTQZ / 100) QZDF\n" +
            "\t\t\t\tFROM\n" +
            "\t\t\t\t\tjx12_khztrw_info t\n" +
            "\t\t\t\tWHERE\n" +
            "\t\t\t\t\tt.khnf = :khnf\n" +
            "\t\t\t\tAND t.khzq = :khzq\n" +
            "\t\t\t\tAND t.khdxid = :khdxid\n" +
            "\t\t\t\tAND t.khlx = '绩效'\n" +
            "\t\t\t\tGROUP BY\n" +
            "\t\t\t\t\tt.ZBLX,\n" +
            "\t\t\t\t\tt.KHZTJS,\n" +
            "\t\t\t\t\tt.KHZT,\n" +
            "\t\t\t\t\t(t.KHDF * t.KHZTQZ / 100)\n" +
            "\t\t\t) a\n" +
            "\t\tGROUP BY\n" +
            "\t\t\ta.ZBLX,\n" +
            "\t\t\ta.KHZTJS\n" +
            "\t) b GROUP BY b.ZBLX",nativeQuery = true)
    List<JSONObject> querySrlDf(@Param("khdxid") String khdxid, @Param("khnf") String khnf,@Param("khzq")String khzq);


    //查询考核主体权重
    @Query(value="SELECT DISTINCT t.KHZTQZ FROM jx12_khztrw_info t WHERE t.KHDXID =:khdxid AND t.KHNF =:khnf AND t.KHZQ =:khzq AND t.KHZTID =:khztid AND t.KHLX = '绩效'",nativeQuery = true)
    String queryZbQz(@Param("khdxid") String khdxid,@Param("khnf") String khnf,@Param("khzq") String khzq,@Param("khztid") String khztid);


    //查询特殊人员
    @Query(value = "SELECT\n" +
            "\t*\n" +
            "FROM\n" +
            "\tjx12_khztrw_info j12\n" +
            "WHERE\n" +
            "j12.KHZTID = :khztid\n" +
            "AND j12.KHZQ = :khzq\n" +
            "AND j12.KHNF = :khnf\n" +
            "\n" +
            "AND KHDXID IN (\n" +
            "\tSELECT\n" +
            "\t\tID\n" +
            "\tFROM\n" +
            "\t\tau01_user\n" +
            "\tWHERE\n" +
            "\t\tUSER_EXTEND LIKE '%特殊人员%'\n" +
            ") ",nativeQuery = true)
    List<JSONObject> queryTsry(@Param("khztid") String khztid, @Param("khzq") String khzq, @Param("khnf")String khnf);
}