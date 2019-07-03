package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-07-09 13:10:44
 * @ModifiedBy
 * @ModifiedDate
 */

@EnableTransactionManagement
@SpringBootApplication
@ServletComponentScan
@EnableJpaAuditing
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
