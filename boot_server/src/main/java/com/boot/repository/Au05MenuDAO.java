package com.boot.repository;

import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description
 * @CreateDate 创建时间： 2019-01-15 17:47:54
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Au05MenuDAO extends BaseDAO<Au05MenuPO, String> {

    @Query(value="SELECT * FROM au05_menu WHERE PARENT_ID =:parentid AND id IN (SELECT menu_id mid FROM au14_menu_role WHERE role_id =:roleid) order  by CONVERT (id USING gbk)", nativeQuery = true)
    List<Au05MenuPO> getByParentidandRoleid(@Param("roleid") String roleid,@Param("parentid") String parentid);

    @Query(value="SELECT m1.* FROM au05_menu m1,au05_menu m2 where m1.id = m2.PARENT_ID  AND m2.id IN (SELECT mr.menu_id FROM au11_user_role u_r,au14_menu_role mr WHERE u_r.role_id = mr.role_id AND u_r.user_id =:userid) ORDER BY m1.id", nativeQuery = true)
    List<Au05MenuPO> getMenusByHrId(@Param("userid") String userid);


    @Query(value="SELECT * FROM au05_menu WHERE PARENT_ID =:parentid AND id IN (SELECT menu_id mid FROM au14_menu_role WHERE role_id in (:roleids)) order  by  CONVERT (id USING gbk)", nativeQuery = true)
    List<Au05MenuPO> getByParentidandRoleid1(@Param("roleids") List roleids,@Param("parentid") String parentid);

}