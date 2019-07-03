package com.boot.repository;

import com.alibaba.fastjson.JSONObject;
import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author CodeGen
 * @Description 对表AU03_ROLE的CURD操作
 * @CreateDate 创建时间：2018-07-23 14:46:21
 * @ModifiedBy
 * @ModifiedDate
 */

public interface Au03RoleDAO extends BaseDAO<Au03RolePO, String> {

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
    @Query(value = "select t.ID,t.ROLE_CODE,t.ROLE_DESC,t.ROLE_NAME,t.OPR_CRT_TIME from au03_role t where t.ID=:id",nativeQuery = true)
    Au03RolePO findAu03RolePOByRoleId(@Param("id") String id);
    //Au03RoleVO findAu03RolePOByRoleId(String id);

    List<Au03RolePO> findAll();

    @Query(value = "SELECT r.ID,r.ROLE_NAME from au03_role r LEFT JOIN au11_user_role ur on r.ID=ur.ROLE_ID where ur.USER_ID=:id",nativeQuery = true)
    List<JSONObject> queryByUserid(@Param("id") String id);
}