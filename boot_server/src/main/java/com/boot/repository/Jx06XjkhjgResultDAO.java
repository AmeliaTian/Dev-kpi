package com.boot.repository;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description
 * @CreateDate 创建时间： 2019-04-28 11:37:24
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Jx06XjkhjgResultDAO extends BaseDAO<Jx06XjkhjgResultPO, String> {


    //根据考核对象id  考核主体id  考核年份  考核周期查询是否有指标考核结果
    @Query(value="select * from jx06_xjkhjg_result t where t.KHDXID=:khdxid and t.KHZTID=:khztid and t.KHNF=:khnf and t.KHZQ=:khzq",nativeQuery = true)
    List<Jx06XjkhjgResultPO> queryZbkhjg(@Param("khztid")String khztid,@Param("khdxid") String khdxid,@Param("khnf")String khnf,@Param("khzq")String khzq);

    //根据指标id  考核年份  考核周期查询指标得分
    @Query(value="select ID AS  ZBDFID,ZBDF AS DF from jx06_xjkhjg_result t where t.ZBID=:zbid  and t.KHNF=:khnf and t.KHZQ=:khzq",nativeQuery = true)
    JSONObject queryZbdf(@Param("khnf")String khnf, @Param("khzq")String khzq, @Param("zbid") String zbid);


    @Query(value="select t.id as zbdfid, t.ZBID,t.ZBDF as df from jx06_xjkhjg_result t where t.KHDXID=:khdxId and t.KHDXLB=:khdxLb and t.KHZTID=:khztId and t.KHNF=:khnf and t.KHZQ=:khzq and t.ZBLX=:zblx",nativeQuery = true)
    List<JSONObject> queryDf(@Param("khnf") String khnf, @Param("khzq") String khzq,@Param("khztId") String khztId,@Param("khdxId") String khdxId,@Param("zblx") String zblx,@Param("khdxLb") String khdxLb);


}