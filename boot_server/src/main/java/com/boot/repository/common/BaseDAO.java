package com.boot.repository.common;



import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author h3dwy
 * @Description 通用查询，仅写接口即可，不需要实现类
 * @CreateDate 创建时间：2018-06-16 23:11
 * @ModifiedBy
 * @ModifiedDate
 */

public interface BaseDAO<T, ID> extends CrudRepository<T, ID>, JpaSpecificationExecutor<T>, QuerydslPredicateExecutor {



    /**
     * 根据ID列表查询所有数据
     *
     * @param ids
     * @return
     */
    @Override
    List<T> findAllById(Iterable<ID> ids);

    /**
     * 查询表中全部数据
     *
     * @return
     */
    @Override
    List<T> findAll();

    /**
     * 根据ID查询数据是否存在
     *
     * @param id
     * @return
     */
    @Override
    boolean existsById(ID id);

    /**
     * 存储对象，如果id在库中存在，则更新
     *
     * @param entity
     * @return
     */
    @Override
    <S extends T> S save(S entity);

    /**
     * 批量存储对象，如果id在库中存在，则更新
     *
     * @param entitys
     * @return
     */

    @Override
    <S extends T> List<S> saveAll(Iterable<S> entitys);

    /**
     * 查询数据表记录数
     *
     * @return
     */
    @Override
    long count();

    /**
     * 根据ID删除数据，如果id不存在，则会抛出异常EmptyResultDataAccessException
     *
     * @param id
     */
    @Override
    void deleteById(ID id);

    /**
     * 根据实体删除数据，仅判断实体的id
     *
     * @param entity
     */
    @Override
    void delete(T entity);

    /**
     * 根据实体列表删除所有数据，仅判断实体的id
     *
     * @param entitys
     */
    @Override
    void deleteAll(Iterable<? extends T> entitys);
}
