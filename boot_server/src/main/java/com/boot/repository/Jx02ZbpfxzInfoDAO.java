package com.boot.repository;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description
 * @CreateDate 创建时间： 2019-04-09 15:30:22
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Jx02ZbpfxzInfoDAO extends BaseDAO<Jx02ZbpfxzInfoPO, String> {

    @Query(value = "SELECT t.id from jx02_zbpfxz_info t where t.ZBGID=:zbgid",nativeQuery = true)
    List<String> findIdByGid(@Param("zbgid") String zbgid);

    @Query(value = "SELECT a.ID as SFMXID,a.MXBH,a.MXFZ,a.MXMC,a.SFINFO,a.SFID,a.SF,a.SFLX,a.SFMC,b.MXWCQKID,b.MXWCQK,b.KHNF from ((SELECT t.ID,t.MXBH,t.MXFZ,t.MXMC,t.SFINFO,t.SFID,ts.SF,ts.SFLX,ts.SFMC FROM jx02_zbpfxz_info t LEFT JOIN jx18_sfmb_info ts ON t.SFID = ts.ID  WHERE t.ZBGID =:zbgid ORDER BY t.MXBH)a LEFT JOIN (select tz.ID as MXWCQKID,tz.MXWCQK,tz.KHNF,tz.SFMXID from jx20_zbwcqk_info tz where tz.KHNF=:khnf)b  ON a.ID = b.SFMXID ) ORDER BY a.MXBH",nativeQuery = true)
    List<JSONObject> queryByZbgid(@Param("zbgid") String zbgid,@Param("khnf") String khnf);
}