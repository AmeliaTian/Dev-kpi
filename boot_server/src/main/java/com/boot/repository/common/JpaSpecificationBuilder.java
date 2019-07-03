package com.boot.repository.common;

import com.boot.utils.DateConverterUtils;
import com.boot.utils.ReflectUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author h3dwy
 * @Description 对Spring data jpa的过滤条件进行重置，用于实现大于、小于等查询
 * @CreateDate 创建时间：2018-10-24 13:50
 * @ModifiedBy
 * @ModifiedDate
 */

public class JpaSpecificationBuilder<T> implements Specification {
    private Map<String, Object> paramMap;
    private Map<String, String> poFieldMap;

    public JpaSpecificationBuilder(Map<String, Object> paramMap, Class<T> t) {
        this.paramMap = paramMap;
        this.poFieldMap = loadClassField(t);
    }

    @Nullable
    @Override
    public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (null == paramMap || paramMap.size() < 1) {
            return null;
        }

        List<Predicate> predicates = new ArrayList<>();
        for (Map.Entry<String, Object> fieldMap : paramMap.entrySet()) {
            String[] paramArr = getOperation(fieldMap.getKey());
            //如果值为空或不是实体的属性，则不处理
            if (null == fieldMap.getValue() || null == poFieldMap.get(paramArr[0])) {
                continue;
            }
            //
            List<String> paramValue = transValue(fieldMap.getValue());
            //属性类型
            String filedType = poFieldMap.get(paramArr[0]);

            if ("java.util.Date".equals(filedType)) {
                List<Date> dValue = DateConverterUtils.convertToDateList(paramValue);
                //如果是日期类型
                switch (paramArr[1]) {
                    case "EQ":
                        //相等
                        dValue.forEach(date -> predicates.add(criteriaBuilder.equal(root.<Date>get(paramArr[0]), date)));
                        break;
                    case "NEQ":
                        //NOT EQUEL
                        dValue.forEach(date -> predicates.add(criteriaBuilder.notEqual(root.<Date>get(paramArr[0]), date)));
                        break;
                    case "GT":
                        //大于
                        dValue.forEach(date -> predicates.add(criteriaBuilder.greaterThan(root.<Date>get(paramArr[0]), date)));
                        break;
                    case "LT":
                        //小于
                        dValue.forEach(date -> predicates.add(criteriaBuilder.lessThan(root.<Date>get(paramArr[0]), date)));
                        break;
                    case "GE":
                        //大于等于
                        dValue.forEach(date -> predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.<Date>get(paramArr[0]), date)));
                        break;
                    case "LE":
                        //小于等于
                        dValue.forEach(date -> predicates.add(criteriaBuilder.lessThanOrEqualTo(root.<Date>get(paramArr[0]), date)));
                        break;
                    case "NU":
                        //IS NULL
                        predicates.add(criteriaBuilder.isNull(root.<Date>get(paramArr[0])));
                        break;
                    case "NNU":
                        //IS NOT NULL
                        predicates.add(criteriaBuilder.isNotNull(root.<Date>get(paramArr[0])));
                        break;
                    default:
                        //相等
                        dValue.forEach(date -> predicates.add(criteriaBuilder.equal(root.<Date>get(paramArr[0]), date)));
                }
            } else {
                switch (paramArr[1]) {
                    case "EQ":
                        //相等
                        paramValue.forEach(val -> predicates.add(criteriaBuilder.equal(root.get(paramArr[0]), val)));
                        break;
                    case "NEQ":
                        //NOT EQUEL
                        paramValue.forEach(val -> predicates.add(criteriaBuilder.notEqual(root.get(paramArr[0]), val)));
                        break;
                    case "GT":
                        //大于
                        paramValue.forEach(val -> predicates.add(criteriaBuilder.greaterThan(root.get(paramArr[0]), val)));
                        break;
                    case "LT":
                        //小于
                        paramValue.forEach(val -> predicates.add(criteriaBuilder.lessThan(root.get(paramArr[0]), val)));
                        break;
                    case "GE":
                        //大于等于
                        paramValue.forEach(val -> predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(paramArr[0]), val)));
                        break;
                    case "LE":
                        //小于等于
                        paramValue.forEach(val -> predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(paramArr[0]), val)));
                        break;
                    case "LK":
                        //LIKE
                        paramValue.forEach(val -> predicates.add(criteriaBuilder.like(root.get(paramArr[0]), "%" + val + "%")));
                        break;
                    case "NLK":
                        //NOT LIKE
                        paramValue.forEach(val -> predicates.add(criteriaBuilder.notLike(root.get(paramArr[0]), "%" + val + "%")));
                        break;
                    case "ST":
                        //STARTWITH
                        paramValue.forEach(val -> predicates.add(criteriaBuilder.like(root.get(paramArr[0]), val + "%")));
                        break;
                    case "NST":
                        //NOT STARTWITH
                        paramValue.forEach(val -> predicates.add(criteriaBuilder.notLike(root.get(paramArr[0]), val + "%")));
                        break;
                    case "ED":
                        //ENDWITH
                        paramValue.forEach(val -> predicates.add(criteriaBuilder.like(root.get(paramArr[0]), "%" + val)));
                        break;
                    case "NED":
                        //NOT ENDWITH
                        paramValue.forEach(val -> predicates.add(criteriaBuilder.notLike(root.get(paramArr[0]), "%" + val)));
                        break;
                    case "NU":
                        //IS NULL
                        predicates.add(criteriaBuilder.isNull(root.get(paramArr[0])));
                        break;
                    case "NNU":
                        //IS NOT NULL
                        predicates.add(criteriaBuilder.isNotNull(root.get(paramArr[0])));
                        break;
                    case "IN":
                        //IN
                        CriteriaBuilder.In in = criteriaBuilder.in(root.get(paramArr[0]));
                        paramValue.forEach(in::value);
                        predicates.add(in);
                        break;
                    case "NIN":
                        //NOT IN
                        CriteriaBuilder.In nin = criteriaBuilder.in(root.get(paramArr[0]));
                        paramValue.forEach(nin::value);
                        predicates.add(criteriaBuilder.not(nin));
                        break;
                    default:
                        //相等
                        paramValue.forEach(val -> predicates.add(criteriaBuilder.equal(root.get(paramArr[0]), val)));
                }
            }
        }

        //如果有op参数，且为OR
        if (null != paramMap.get("op") && "OR".equals(paramMap.get("op").toString().toUpperCase())) {
            return criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()]));
        } else {
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        }
    }

    /**
     * 获取操作类型
     *
     * @param paramName paramName格式为实体参数+操作方式, 如userName.LK=
     * @return
     */
    private String[] getOperation(String paramName) {
        //如果没有操作符后缀，则默认为等于
        if (paramName.indexOf(".") < 0) {
            return new String[]{paramName, "EQ"};
        }
        String[] tmp = paramName.split("\\.");
        return new String[]{tmp[0], tmp[1].toUpperCase()};
    }

    /**
     * 获取值
     *
     * @param paramValue
     * @return
     */
    private List<String> transValue(Object paramValue) {
        //从URL传的param，如果同一个参数名，会生成为List,此时只取同名参数的第一个值
        //此处参数为param.LT,parm.GT等这种类型的
        return paramValue instanceof List ? (List) paramValue : new ArrayList<String>() {{
            add(paramValue.toString());
        }};
    }

    /**
     * 获取PO类的属性名和后台存储类型
     *
     * @return <属性名，属性类型>
     */
    private Map<String, String> loadClassField(Class<T> entityClass) {
        List<Field> fields = ReflectUtils.getFields(entityClass);
        Map<String, String> fieldMap = new HashMap<>();
        for (Field field : fields) {
            fieldMap.put(field.getName(), field.getType().getName());
        }
        return fieldMap;
    }
}
