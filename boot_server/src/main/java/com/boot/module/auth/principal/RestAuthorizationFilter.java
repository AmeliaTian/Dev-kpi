package com.boot.module.auth.principal;

import com.boot.constant.WebConstants;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.ArrayUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author h3dwy
 * @CreateDate 创建时间：2017-07-27 13:41
 * @ModifiedBy 过滤rest的不同访问
 * @ModifiedDate
 */
@Component
public class RestAuthorizationFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) throws Exception {
        Subject subject = getSubject(servletRequest, servletResponse);

        String method = ((HttpServletRequest) servletRequest).getMethod().toUpperCase();
        String[] methodArray = (String[]) mappedValue;
        //如果已登录，且资源没有方法限制，则有权限访问
        if (ArrayUtils.isEmpty(methodArray) && subject.isAuthenticated()) {
            return true;
        }

        for (String med : methodArray) {
            String meth = med.substring(0, med.indexOf(":"));
            //如果当前访问方式不是允许的方式，则继续判断
            if (!method.equals(meth.toUpperCase())) {
                continue;
            } else {
                String[] roles = med.substring(med.indexOf(":") + 1).split("\\|");
                for (String role : roles) {
                    //表示可非登录访问,LOGIN_ANY
                    if (WebConstants.ALLOW_UNLOGIN_USERS_INVOKE_NAME.equals(role)) {
                        return true;
                    } else {
                        //登录，并且包含角色或任意角色
                        //包含了任一角色，或角色中包含ROLE_ANY，则有权限
                        if (subject.isAuthenticated() && (subject.hasRole(role) || WebConstants.ALLOW_ALL_ROLES_INVOKE_NAME.equals(role))) {
                            return true;
                        }
                    }
                }
            }
        }
        return subject.isAuthenticated();
    }
}
