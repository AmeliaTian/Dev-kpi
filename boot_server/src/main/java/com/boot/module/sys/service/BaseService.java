package com.boot.module.sys.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-06-19 10:53
 * @ModifiedBy
 * @ModifiedDate
 */

public class BaseService {

    @Autowired
    @PersistenceContext
    protected EntityManager entityManager;
    protected JPAQueryFactory queryFactory;

    @PostConstruct
    public void init() {
        queryFactory = new JPAQueryFactory(entityManager);
    }

    /**
     * 在更新或查询时，对前台传入的参数值进行完善或修改
     *
     * @param queryParamMap
     * @param extendsParmMap
     */
    protected void extendParamMap(Map<String, Object> queryParamMap, Map<String, Object> extendsParmMap) {
        if (null != extendsParmMap) {
            queryParamMap = (null == queryParamMap) ? new HashMap<>() : queryParamMap;
            //
            queryParamMap.putAll(extendsParmMap);
        }
    }
}
