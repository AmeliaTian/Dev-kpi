package com.boot.repository;

import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Description
 * @CreateDate 创建时间： 2019-03-06 10:16:20
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Jx16ZqmanageInfoDAO extends BaseDAO<Jx16ZqmanageInfoPO, String> {

    @Query(value = "select * from jx16_zqmanage_info where yxbs='Y'",nativeQuery = true)
    List<Jx16ZqmanageInfoPO>  queryAll();
}