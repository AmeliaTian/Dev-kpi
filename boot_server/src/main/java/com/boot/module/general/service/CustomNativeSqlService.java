package com.boot.module.general.service;

import com.boot.module.sys.ObjectNameTools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author h3dwy
 * @Description 自定义sql查询
 * @CreateDate 创建时间：2018-07-22 18:02
 * @ModifiedBy
 * @ModifiedDate
 */

@Slf4j
@Service("customNativeSqlService")
public class CustomNativeSqlService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    /**
     * @param sql   需要使用:label方式替换jdbc中的？
     *              如：select * from user where age>:age
     * @param param 参数值
     * @return
     */
    public List<Map<String, Object>> queryBySqlMapParams(String sql, Map<String, Object> param) {
        return namedParameterJdbcTemplate.query(sql, param, new RowMapperNameToLower());
    }

    /**
     * 调用HQL语句查询数据
     *
     * @param hql
     * @param params
     * @param currentPage
     * @param pageSize
     * @return
     */
    public List queryByHqlMapParams(String hql, Map<String, Object> params, Integer currentPage, Integer pageSize) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery(hql);
        List list = null;
        try {
            if (params != null && !params.isEmpty()) {
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    query.setParameter(entry.getKey(), entry.getValue());
                }
            }
            if (currentPage != null && pageSize != null) {
                query.setFirstResult((currentPage - 1) * pageSize);
                query.setMaxResults(pageSize);
            }
            list = query.getResultList();
        } catch (Exception e) {
            log.error("", e);
        } finally {
            entityManager.close();
        }
        return list;
    }

    /**
     * 执行sql
     * String sql = "insert into user(username, address, age) values(:name, :address, :age)";
     * Map<String, Object> paramMap = new HashMap();
     * paramMap.put("name", "openwrt");
     * paramMap.put("address", "am");
     * paramMap.put("age", 34);
     *
     * @param sql
     * @param params
     * @return
     */
    public int executeBySqlMapParams(String sql, Map<String, Object> params) {
        return namedParameterJdbcTemplate.update(sql, params);
    }

    public int[] executeBatchBySqlMapParams(String sql, List<Map<String, Object>> params) {
        Map<String, Object>[] paramMap = params.toArray(new Map[params.size()]);
        return namedParameterJdbcTemplate.batchUpdate(sql, paramMap);
    }

    /**
     * 将字段名转换为小写
     */
    private static class RowMapperNameToLower implements RowMapper<Map<String, Object>> {
        @Nullable
        @Override
        public Map<String, Object> mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            Map<String, Object> map = new HashMap();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnLabel(i);
                String transName= ObjectNameTools.dbNameToObjName(columnName, false);
                map.put(transName, resultSet.getObject(columnName.toLowerCase()));
            }
            return map;
        }
    }
}
