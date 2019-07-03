package com.boot.web.init;

import com.boot.module.auth.principal.AuthShiroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author h3dwy
 * @Description CommandLineRunner 接口的 Component 会在所有 Spring Beans 都初始化之后，SpringApplication.run() 之前执行，非常适合在应用程序启动之初进行一些数据初始化的工作；通过实现接口 CommandLineRunner 来实现数据初始化。无需其他配置，只要创建一个类去实现接口 CommandLineRunner就可以了。
 * @CreateDate 创建时间：2018-08-29 9:45
 * @ModifiedBy
 * @ModifiedDate
 */

@Component
@Slf4j
@Order(1)
public class AppDataInit implements CommandLineRunner {
    @Resource(name = "shiroService")
    private AuthShiroService shiroService;

    @Override
    public void run(String... args) throws Exception {
        log.info("数据初始化开始：...........................");
        //此处刷新用户及对应的角色，由于角色信息需要判断父级角色，并且后台查询效率低，因此存储入缓存中
        log.info("加载用户权限信息开始：...........................");
        shiroService.refreshUserRoles();
        log.info("加载用户权限信息结束：...........................");

        log.info("数据初始化结束：...........................");
    }
}
