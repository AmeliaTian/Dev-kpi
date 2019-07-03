package com.boot.repository;

import com.boot.repository.common.BaseDAO;

/**
 * @author CodeGen
 * @Description 对表AT01_JSON_OBJECT的CURD操作
 * @CreateDate 创建时间：2018-08-13 11:27:28
 * @ModifiedBy
 * @ModifiedDate
 */

public interface At01JsonObjectDAO extends BaseDAO<At01JsonObjectPO, String> {

/*-------数据库操作(DAO中的实现)规范-------
  -----命名规范------
    数据库的操作、增删改查等，自定义方法（非spring jpa风格），参照以下方式命名
    1）获取单个对象的方法用get做前缀。
    2）获取多个对象的方法用list做前缀。
    3）获取统计值的方法用count做前缀。
    4）插入的方法用save做前缀。
    5）删除的方法用remove做前缀。
    6）修改的方法用update做前缀。
  -----方法实现规范------
    //查询，查询推荐使用第1和第2种方法，禁止使用方法3
    方法1：通过解析方法名实现
        List<Uc08DataDictEntity> findByDictCode(String dictCode);
    方法2：
        @Query("from Uc08DataDictEntity u where dictCode = ?1")
        List<Uc08DataDictEntity> findTest1(String dictCode);
    方法3：
        @Query(value="select * from uc08_data_dict u where dict_code = :first and application_code =:appCode", nativeQuery = true)
        List<Uc08DataDictEntity> findTest3(@Param("first") String dictCode, @Param("appCode") String appCode);
    方法4（禁止使用）：
        @Query(value ="select * from uc08_data_dict u where dict_code = ?1 and application_code =?2", nativeQuery = true)
        List<Uc08DataDictEntity> findTest2(String dictCode, String appCode);
    更新方法：
        @Modifying
        @Query("update Uc08DataDictEntity set applicationCode = ?1")
        int dictUpdate(String appCode);
*/
}