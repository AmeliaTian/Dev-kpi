package com.boot.repository;

import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * @Description
 * @CreateDate 创建时间： 2018-12-26 15:25:20
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Jx01ZbkInfoDAO extends BaseDAO<Jx01ZbkInfoPO, String> {


    @Query(value="select * from jx01_zbk_info where id=:id",nativeQuery = true)
    Jx01ZbkInfoPO findByZbId(@Param("id")String id);

    @Query(value = "select * from jx01_zbk_info where YXBS='Y' and id in (:idList)",nativeQuery = true)
    List<Jx01ZbkInfoPO> getByIdArr(@Param("idList") List<String> idList);

    @Query(value = "select * from jx01_zbk_info t ORDER BY t.SSDL,t.ZBLSBM,t.ZBLB",nativeQuery = true)
    List<Jx01ZbkInfoPO> getAll();

    @Query(value="select  DISTINCT z.ZBMC from jx01_zbk_info z where z.SSDL='态度类' and z.YXBS='Y'",nativeQuery = true)
    List<String> getZbmc();

    @Query(value="select * from jx01_zbk_info t where t.ZBMC=:zbmc and t.YXBS='Y' ORDER BY id DESC",nativeQuery = true)
    List<Jx01ZbkInfoPO> getZb(@Param("zbmc")String zbmc);
}