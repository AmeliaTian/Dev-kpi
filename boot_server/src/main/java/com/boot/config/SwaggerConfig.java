package com.boot.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-06-29 14:11
 * @ModifiedBy
 * @ModifiedDate
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${sys-custom.swagger.show-api}")
    private boolean showApi;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(showApi)
                .apiInfo(apiInfo())
                .select()
                //扫描方法上标识了注解的类
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("api文档").version("1.0").build();
    }
}
