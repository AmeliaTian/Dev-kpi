package com.boot.repository;

import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Description
 * @CreateDate 创建时间： 2019-04-17 14:36:59
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Jx20ZbwcqkInfoDAO extends BaseDAO<Jx20ZbwcqkInfoPO, String> {

    @Query(value="select * from jx20_zbwcqk_info t where t.SFMXID=:zbid and t.KHNF=:khnf ",nativeQuery = true)
    Jx20ZbwcqkInfoPO findBySfmxid(@Param("zbid") String zbid, @Param("khnf") String khnf);
}