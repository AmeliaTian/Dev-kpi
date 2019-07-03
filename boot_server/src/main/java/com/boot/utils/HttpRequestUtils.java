package com.boot.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-09-30 14:00
 * @ModifiedBy
 * @ModifiedDate
 */

public class HttpRequestUtils {
    /**
     * 从request中获取参数，组成普通map
     *
     * @param request
     * @param exParamName 排除这些参数
     * @return
     */
    public static Map<String, Object> getParameterMapFromRequest(HttpServletRequest request, List<String> exParamName) {
        //把请求参数封装到Map<String, String[]>中
        Map<String, String[]> propMap = request.getParameterMap();
        Map<String, Object> returnMap = new HashMap();
        String name;
        for (Map.Entry<String, String[]> entry : propMap.entrySet()) {
            //去除列表中的参数，不加入返回值中
            if (exParamName.contains(entry.getKey())) {
                continue;
            }
            name = entry.getKey();
            String[] valueObj = entry.getValue();
            if (null == valueObj) {
                returnMap.put(name, "");
            } else if (valueObj.length > 1) {
                //如果是多个值，则放入list中
                returnMap.put(name, Arrays.asList(valueObj));
            } else {
                returnMap.put(name, valueObj[0]);
            }
        }
        return returnMap;
    }
}
