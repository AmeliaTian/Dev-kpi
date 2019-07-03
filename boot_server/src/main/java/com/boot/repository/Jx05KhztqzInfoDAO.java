package com.boot.repository;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description
 * @CreateDate 创建时间： 2019-03-05 10:30:58
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Jx05KhztqzInfoDAO extends BaseDAO<Jx05KhztqzInfoPO, String> {


    @Query(value = "select * from jx05_khztqz_info where KHZTJSID=:khztjsid",nativeQuery = true)
    List<Jx05KhztqzInfoPO> findByKhdxjsId(@Param("khztjsid") String khztjsid);

    @Query(value = "select QZ from jx05_khztqz_info where KHDXJSID=:khdxjsid AND KHZTJSID =:khztjsid and bz=:bz",nativeQuery = true)
    String findQz(@Param("khdxjsid") String khdxjsid,@Param("khztjsid") String khztjsid,@Param("bz") String bz);

    @Query(value = "SELECT u.ID,u.USER_NAME,u.USER_NAME_CN FROM au01_user u WHERE u.id IN (SELECT ur.user_id FROM au11_user_role ur WHERE ur.role_id IN ( SELECT r.id FROM au03_role r WHERE r.role_name = '人力资源管理委员会' ))",nativeQuery = true)
    List<JSONObject> queryUserZz();

    @Query(value = "select t.ID,t.KHDXJS,t.KHDXJSID,t.KHZTJS,t.KHZTJSID,t.QZ,t.ZBDL from jx05_khztqz_info t WHERE t.KHDXJSID=:khdxjsid ORDER BY FIELD(t.KHZTJS ,'公司董事长','公司总经理','公司领导','分管领导','总部各部门','所属公司正职')",nativeQuery = true)
    List<JSONObject> queryByKhdxjsId(@Param("khdxjsid") String khdxjsid);

    @Query(value = "select t.ID,t.KHDXJS,t.KHDXJSID,t.KHZTJS,t.KHZTJSID,t.QZ,t.ZBDL,t.BZ from jx05_khztqz_info t WHERE t.KHDXJSID=:khdxjsid AND t.BZ=:bz AND t.ZBDL=:zblx ORDER BY FIELD(t.KHZTJS ,'公司董事长','公司总经理','公司领导','分管领导','总部各部门','所属公司正职')",nativeQuery = true)
    List<JSONObject> queryYg(@Param("khdxjsid") String khdxjsid,@Param("bz") String bz,@Param("zblx") String zblx);
}