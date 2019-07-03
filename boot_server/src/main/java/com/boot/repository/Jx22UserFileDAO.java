package com.boot.repository;

import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description
 * @CreateDate 创建时间： 2019-06-18 17:10:28
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Jx22UserFileDAO extends BaseDAO<Jx22UserFilePO, String> {
    @Query(value = "select * from jx22_user_file t where t.KHNF=:khnf and t.KHZQ=:khzq and t.KHDXID=:khdxid",nativeQuery = true)
    List<Jx22UserFilePO> findByKhnfAndKhzqAndKhdxid(@Param("khnf") String khnf, @Param("khzq") String khzq, @Param("khdxid") String khdxid);
//    @Query(value = "select * from jx22_user_file t where t.KHDXID=:khdxid",nativeQuery = true)
//    List<Jx22UserFilePO> findByKhdxid(@Param("khdxid") String khdxid);
    @Query(value = "select * from jx22_user_file t where t.KHNF=:khnf and t.KHZQ=:khzq",nativeQuery = true)
    List<Jx22UserFilePO> findByKhnfAndKhzq(@Param("khnf") String khnf, @Param("khzq") String khzq);
    @Query(value = "select * from jx22_user_file t where t.KHNF=:khnf and t.KHZQ=:khzq and t.SSBMID in (:orgIds)",nativeQuery = true)
    List<Jx22UserFilePO> findByKhnfAndKhzqAndOrgid(@Param("khnf") String khnf, @Param("khzq") String khzq, @Param("orgIds") List<String> orgIds);
    @Query(value = "select FJMC from jx22_user_file where ID in (:ids)",nativeQuery = true)
    List<String> findFjmcById(@Param("ids") List<String> ids);
}