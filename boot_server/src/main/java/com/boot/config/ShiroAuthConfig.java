package com.boot.config;

import com.boot.constant.WebConstants;
import com.boot.module.auth.principal.AuthSessionManager;
import com.boot.module.auth.principal.AuthShiroCusRealm;
import com.boot.module.auth.principal.RestAuthorizationFilter;
import com.boot.module.auth.service.IAu04PrivilegeService;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author h3dwy
 * @Description shiro顺序机制:
 * 相同url规则，后面定义的会覆盖前面定义的(执行的时候只执行最后一个)。
 * 两个url规则都可以匹配同一个url，只执行第一个。
 * @CreateDate 创建时间：2018-07-26 16:21
 * @ModifiedBy
 * @ModifiedDate
 */

@Configuration
public class ShiroAuthConfig {
    @Resource(name = "au04PrivilegeService")
    private IAu04PrivilegeService au04PrivilegeService;

    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //要求用户登录
        shiroFilterFactoryBean.setLoginUrl("/login");
        //未授权界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/auth/nologin");
        //自定义拦截器
        Map<String, Filter> filtersMap = new LinkedHashMap<>();
        //请求方法
        filtersMap.put("restFilter", new RestAuthorizationFilter());
        shiroFilterFactoryBean.setFilters(filtersMap);

        // 拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 静态资源
        filterChainDefinitionMap.put("/assets/**", "anon");
        // js引用
        filterChainDefinitionMap.put("/all.js", "anon");
        //错误页面
        filterChainDefinitionMap.put("/error/**", "anon");
        // 设置登录的URL为匿名访问
        filterChainDefinitionMap.put("/auth/login", "anon");
        // 退出系统的过滤器
        filterChainDefinitionMap.put("/auth/logout", "anon");
        // 未登录消息
        filterChainDefinitionMap.put("/auth/nologin", "anon");

        //后台存储的权限
        filterChainDefinitionMap.putAll(au04PrivilegeService.resourcePrivilege());
        //最后
        //filterChainDefinitionMap.put("/**", "authc");
        filterChainDefinitionMap.put("/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public AuthShiroCusRealm authShiroRealm() {
        return new AuthShiroCusRealm();
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 注入自定义的realm;
        securityManager.setRealm(authShiroRealm());
        securityManager.setSessionManager(sessionManager());
        //注入记住我管理器
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    @Bean
    public SessionManager sessionManager() {
        AuthSessionManager authSessionManager = new AuthSessionManager();
        //
        authSessionManager.setSessionDAO(new EnterpriseCacheSessionDAO());
        return authSessionManager;
    }

    /*
     * 开启shiro aop注解支持 使用代理方式;所以需要开启代码支持;
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
            DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * cookie对象;
     * rememberMeCookie()方法是设置Cookie的生成模版，比如cookie的name，cookie的有效时间等等。
     *
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //记住我cookie生效时间7天 ,单位秒;
        simpleCookie.setMaxAge(WebConstants.WEB_REMEMBER_ME_DAY_NUM);
        return simpleCookie;
    }

    /**
     * cookie管理对象;
     * rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
     *
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(WebConstants.COOKIE_CIPHER_KEY.getBytes());
        return cookieRememberMeManager;
    }
}
