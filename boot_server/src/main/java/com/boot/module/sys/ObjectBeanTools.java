package com.boot.module.sys;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-06-15 9:21
 * @ModifiedBy
 * @ModifiedDate
 */
@Slf4j
public class ObjectBeanTools {
    /**
     * 从一个对象，将参数拷贝到另一对象，忽略为空的参数
     *
     * @param src
     * @param target
     */
    public static Object copyPropertiesIgnoreNull(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
        return target;
    }

    /**
     * 从一个对象，将参数拷贝到另一对象，不忽略为空的参数
     *
     * @param src
     * @param target
     */
    public static void copyPropertiesNotIgnoreNull(Object src, Object target) {
        BeanUtils.copyProperties(src, target);
    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }


    /**
     * 根据属性名获取属性值
     *
     * @param fieldName
     * @param object
     * @return
     */
    private static String getFieldValueByFieldName(String fieldName, Object object) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            //设置对象的访问权限，保证对private的属性的访问
            field.setAccessible(true);
            return (String) field.get(object);
        } catch (Exception e) {
            log.error("获取属性值：" + fieldName, e);
            return null;
        }
    }
}