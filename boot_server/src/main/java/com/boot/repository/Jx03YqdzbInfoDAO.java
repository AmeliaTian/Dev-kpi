package com.boot.repository;

import com.boot.repository.common.BaseDAO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


/**
 * @Description
 * @CreateDate 创建时间： 2019-01-09 10:49:45
 * @ModifiedBy
 * @author CodeGen
 * @ModifiedDate
 */
public interface Jx03YqdzbInfoDAO extends BaseDAO<Jx03YqdzbInfoPO, String> {

    Jx03YqdzbInfoPO findByid (String id);

    @Modifying
    @Query("update Jx03YqdzbInfoPO t set yxbs='N',updateUser=?2,updatetime=NOW() where id=?1")
    int  updateYxbsByid(@Param("id") String id, @Param("updateUser") String updateUser);

    @Query(value = "select DISTINCT t.ZBDL from jx03_yqdzb_info t where t.KHDXID=:khdxId and t.KHNF=:khnf and t.YXBS='Y' ORDER BY t.ZBDL is null,t.ZBDL='', FIELD(t.ZBDL,'业绩类', '财务类', '营运类','管理类', '任务类', '创新类', '基础类', '加分类', '重要信息','党建类')",nativeQuery = true)
    List<String> FindZblx(@Param("khdxId") String khdxId, @Param("khnf") String khnf);


    @Query(value = "select * from jx03_yqdzb_info t where t.ZBDL=:zbdl and t.KHNF=:khnf and t.khdxid=:khdxId and t.YXBS='Y'",nativeQuery = true)
    List<Jx03YqdzbInfoPO> FindZb(@Param("zbdl") String zbdl,@Param("khnf") String khnf,@Param("khdxId") String khdxId);


    @Query(value = "select DISTINCT t.ZBDL from jx03_yqdzb_info t where t.KHDXID=:khdxId and t.KHNF=:khnf and t.khzq like CONCAT(:khzq,'%') and t.YXBS='Y'",nativeQuery = true)
    List<String> FindKhZblx(@Param("khdxId") String khdxId, @Param("khnf") String khnf,@Param("khzq")String khzq);

    @Query(value = "select * from jx03_yqdzb_info t where t.ZBDL=:zbdl and t.KHNF=:khnf and t.khdxid=:khdxId  and t.khzq like CONCAT(:khzq,'%') and t.YXBS='Y'",nativeQuery = true)
    List<Jx03YqdzbInfoPO> FindKhZb(@Param("zbdl") String zbdl,@Param("khnf") String khnf,@Param("khdxId") String khdxId,@Param("khzq")String khzq);


    @Query(value = "select * from jx03_yqdzb_info t where  t.KHNF=:khnf and t.khdxid=:khdxId and t.YXBS='Y' ORDER BY t.ZBDL is null,t.ZBDL='', FIELD(t.ZBDL,'业绩类','基础类', '财务类', '营运类','管理类', '任务类', '创新类',  '加分类', '重要信息','党建类'),t.id",nativeQuery = true)
    List<Jx03YqdzbInfoPO> FindZb1(@Param("khnf") String khnf,@Param("khdxId") String khdxId);

    @Query(value="SELECT * from  jx03_yqdzb_info t  where t.YXBS='Y' and t.id in (:idList)",nativeQuery = true)
    List<Jx03YqdzbInfoPO> getByIdArr(@Param("idList") List<String> idList);

    //@Query(value = "select * from jx03_yqdzb_info t where  t.KHNF=:khnf and t.khdxid=:khdxId and t.YXBS='Y' AND  t.KHZQ like CONCAT('%',:khzq,'%') ORDER BY t.ZBDL is null,t.ZBDL='', FIELD(t.ZBDL,'业绩类', '基础类',  '财务类', '营运类','管理类', '任务类', '创新类','加分类', '重要信息','党建类'),t.id",nativeQuery = true)
    //List<Jx03YqdzbInfoPO> queryZb(@Param("khnf") String khnf,@Param("khdxId") String khdxId,@Param("khzq") String khzq);


    @Query(value = "select * from jx03_yqdzb_info t where  t.KHNF=:khnf and t.khdxid=:khdxId and t.YXBS='Y'  ORDER BY t.ZBDL is null,t.ZBDL='', FIELD(t.ZBDL,'业绩类', '基础类',  '财务类', '营运类','管理类', '任务类', '创新类','加分类', '重要信息','党建类'),t.id",nativeQuery = true)
    List<Jx03YqdzbInfoPO> queryZb(@Param("khnf") String khnf,@Param("khdxId") String khdxId);



}

