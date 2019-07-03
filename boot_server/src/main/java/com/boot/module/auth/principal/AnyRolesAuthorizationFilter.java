package com.boot.module.auth.principal;

import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Arrays;

/**
 * @author h3dwy
 * @CreateDate 创建时间：2017-07-27 13:41
 * @ModifiedBy 默认的Shiro过滤器是如果有多个角色，则用户必须财时有多个角色时才可以访问
 * 修改为只要有其中一外角色，就可以访问
 * @ModifiedDate
 */

@Component
public class AnyRolesAuthorizationFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) throws Exception {
        Subject subject = getSubject(servletRequest, servletResponse);
        //若用户未登录，则不允许访问
        if (subject.isAuthenticated()) {
            String[] rolesArray = (String[]) mappedValue;

            if (ArrayUtils.isEmpty(rolesArray)) {
                //没有角色限制，有权限访问
                return true;
            }

            //若当前用户是rolesArray中的任何一个或资源设置了ROLE_ANY，则有权限访问
            return Arrays.stream(rolesArray).anyMatch(role -> subject.hasRole(role) || "ROLE_ANY".equals(role));
        }
        return false;
    }
}
