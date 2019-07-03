package com.boot.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

/**
 * @author h3dwy
 * @Description 获取IP地址
 * @CreateDate 创建时间：2018-07-13 15:24
 * @ModifiedBy
 * @ModifiedDate
 */

public class IpRequestUtils {

    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");

            if (StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (("127.0.0.1").equals(ipAddress)) {
                    // 根据网卡取本机配置的IP
                    ipAddress = InetAddress.getLocalHost().getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            // 255.255.255 11位长度，如果大于11位，则判断是否是多个IP
            if (null != ipAddress && ipAddress.length() > 11 && ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        } catch (Exception e) {
            ipAddress = "";
        }
        return ipAddress;
    }
}
