package com.boot.constant;

import com.boot.repository.Au03RoleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author h3dwy
 * @Description 内容缓存
 * @CreateDate 创建时间：2018-09-17 10:28
 * @ModifiedBy
 * @ModifiedDate
 */

@Slf4j
@Component
public class WebStroage {

    /*<-------------用户权限相关----------------------->*/
    /**
     * 用户角色映射,<username(登录名),[角色列表]>
     */
    public static Map<String, Set<Au03RoleVO>> authUserRolesMap = new ConcurrentHashMap<>();

    /**
     * 获取用户角色
     *
     * @param userName
     * @return
     */
    public static Set<Au03RoleVO> loadUserRoles(String userName) {
        return authUserRolesMap.get(userName);
    }
    /*>-------------用户权限相关-----------------------<*/
}
