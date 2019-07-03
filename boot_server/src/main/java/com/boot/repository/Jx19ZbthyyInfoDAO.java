package com.boot.repository;

import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description
 * @CreateDate 创建时间： 2019-04-12 10:34:54
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Jx19ZbthyyInfoDAO extends BaseDAO<Jx19ZbthyyInfoPO, String> {

    List<Jx19ZbthyyInfoPO> findByZbid(String zbid);

    @Query(value="select * from jx19_zbthyy_info t where t.ZBID=:zbId order by t.OPR_CRT_TIME desc", nativeQuery = true)
    List<Jx19ZbthyyInfoPO> getByZbid(@Param("zbId") String zbId);
}