package com.boot.module.sys.service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author CodeGen
 * @Description
 * @CreateDate 创建时间： 2018-09-18 14:44:51
 * @ModifiedBy
 * @ModifiedDate
 */
public interface IBaseService<VO> {
    /**
     * 统计记录数
     *
     * @param queryParamMap
     * @return
     */
    Long countEntity(Map<String, Object> queryParamMap);

    /**
     * 根据过滤条件查询
     *
     * @param queryParamMap 查询参数
     * @param pageable 分页参数
     * @return
     */
    Iterable<VO> queryEntity(Map<String, Object> queryParamMap, Pageable pageable);

    /**
     * 更新数据
     *
     * @param vos)
     * @return
     */
    Integer updateEntity(List<VO> vos);

    /**
     * 更新局部数据,插入新数据
     *
     * @param vos)
     * @return
     */
    Integer saveEntity(List<VO> vos);

    /**
     * 逻辑删除数据
     *
     * @param ids
     * @return
     */
    Integer removeEntity(List<String> ids);
}
