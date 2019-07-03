package com.boot.aoplistener;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-10-18 10:48
 * @ModifiedBy
 * @ModifiedDate
 */

@Aspect
@Component
public class CusAnnotationAnalytic {

    @Pointcut("@annotation(com.boot.aoplistener.CusAnnotation)")
    public void cusAnalytic() {
    }

    /**
     * 1.前置通知（Before）：在目标方法被调用之前调用通知功能。
     * 2.后置通知（After）：在目标方法完成之后调用通知，此时不会关心方法的输出是什么。
     * 3.返回通知（AfterReturning）：在目标方法成功执行之后调用通知。
     * 4.异常通知（AfterThrowing）：在目标方法抛出异常后调用通知。
     * 5.环绕通知（Around）：通知包裹了被通知的方法，在被通知的方法调用之前和调用之后执行自定义的行为。
     */
    @AfterReturning("@annotation(cusAnnotation)")
    public void listenerAnnotation(CusAnnotation cusAnnotation) {
        String behaviorDes = cusAnnotation.behaviorDes();
        try {

            IEventListener listener = (IEventListener) Class.forName("com.boot.aoplistener." + behaviorDes).newInstance();
            listener.eventExecute();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
