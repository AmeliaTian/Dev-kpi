package com.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-08-29 13:17
 * @ModifiedBy
 * @ModifiedDate
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * addViewControllers可以方便的实现一个请求直接映射成视图，而无需书写controller
     * registry.addViewController("请求路径").setViewName("请求页面文件路径")
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/apiDocs").setViewName("redirect:swagger-ui.html");
        //错误页面
        registry.addViewController("/error/401").setViewName("page/error/401");
        registry.addViewController("/error/404").setViewName("page/error/404");
        registry.addViewController("/error/500").setViewName("page/error/500");
    }
}
