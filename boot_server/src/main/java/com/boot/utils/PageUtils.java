package com.boot.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author h3dwy
 * @Description 分页工具类, 根据页数，行数，排序字段生成Pageable类
 * @CreateDate 创建时间：2018-08-24 10:03
 * @ModifiedBy
 * @ModifiedDate
 */

public class PageUtils {
    public static Pageable pageBuilder(Integer page, Integer size, String sort) {
        Pageable pageable = null;
        if (null == page || null == size) {
            return pageable;
        }
        //sort为空，则不排序
        if (StringUtils.isEmpty(sort)) {
            pageable = PageRequest.of(page, size);
        } else {
            //字段分号分隔，排序类型逗号分隔：firstname;lastname,desc;id
            String[] sorts = sort.split(";");
            List<Sort.Order> orderList = new ArrayList<>();
            for (String s : sorts) {
                if (StringUtils.isEmpty(s)) {
                    continue;
                }
                String[] parms = s.split(",");

                Sort.Direction direction = Sort.Direction.ASC;
                //若排序方式为空，则使用ASC
                //若为DESC，则使用DESC
                //其他均使用ASC
                if (parms.length >= 2 && "DESC".equals(parms[1].toUpperCase())) {
                    direction = Sort.Direction.DESC;
                }
                orderList.add(new Sort.Order(direction, parms[0]));
            }
            pageable = PageRequest.of(page, size, Sort.by(orderList));
        }
        return pageable;
    }
}
