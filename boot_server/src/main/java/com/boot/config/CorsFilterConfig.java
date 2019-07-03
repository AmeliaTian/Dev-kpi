package com.boot.config;

import com.boot.constant.WebConstants;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author h3dwy
 * @Description 允许跨域访问
 * @CreateDate 创建时间：2018-08-03 9:27
 * @ModifiedBy
 * @ModifiedDate
 */
@Configuration
public class CorsFilterConfig {
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();
        // 设置你要允许的网站域名，如果全允许则设为 *
        config.addAllowedOrigin(WebConstants.ALLOW_ORIGIN);
        // http头
        config.addAllowedHeader("*");
        config.addAllowedMethod(WebConstants.HTTP_ALLOW_METHODS);
        source.registerCorsConfiguration("/**", config);

        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        // 这个顺序很重要，设置在最前
        bean.setOrder(0);
        return bean;
    }
}
