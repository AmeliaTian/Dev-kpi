package com.boot.repository;

import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description
 * @CreateDate 创建时间： 2019-05-30 14:55:19
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Jx13KhdjgjInfoDAO extends BaseDAO<Jx13KhdjgjInfoPO, String> {
    @Query(value="select distinct(t.KHDJ) from jx13_khdjgj_info t  ",nativeQuery = true)
    List<String> queryDj();


    @Query(value="select * from jx13_khdjgj_info t where t.KHDJ=:djmc",nativeQuery = true)
    List<Jx13KhdjgjInfoPO> queryByDjmc(@Param("djmc")String djmc);
}