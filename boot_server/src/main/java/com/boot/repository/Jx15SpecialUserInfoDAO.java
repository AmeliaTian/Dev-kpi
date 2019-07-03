package com.boot.repository;

import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description
 * @CreateDate 创建时间： 2019-02-14 16:12:35
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Jx15SpecialUserInfoDAO extends BaseDAO<Jx15SpecialUserInfoPO, String> {

   /* @Query(value="select id  from jx15_special_user_info where user_id=:khdxid and khnf=:khnf", nativeQuery = true)
    List<String> getByKhdxIdAndKhnf(@Param("khdxid") String khdxid, @Param("khnf") String khnf);*/
}