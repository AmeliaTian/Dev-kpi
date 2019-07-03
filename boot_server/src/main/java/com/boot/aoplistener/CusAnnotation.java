package com.boot.aoplistener;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @author h3dwy
 * 自定义注解类
 * @CreateDate 创建时间：2017-03-21 15:05
 * @ModifiedBy
 * @ModifiedDate
 */
@Target({ElementType.METHOD}) //在方法上注解
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Documented//说明该注解将被包含在javadoc中
@Order(Ordered.HIGHEST_PRECEDENCE)//最高优先级
public @interface CusAnnotation {
    /**
     * 行为描述
     *
     * @return
     */
    String behaviorDes() default "";
}
