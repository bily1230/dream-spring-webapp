package com.dream.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * Created by ning on 2018/6/30.
 */

/**
 * @Aspect不包含自动注入功能
 */
@Aspect
public class AspectTest {


/*    @Pointcut("execution(* com.dream.spring.manager.AspectJManager.show(..))")
    public void performance(){}

    @Before("performance()")
    public void beforeShow() {
            System.out.println("before------------------------------------------------");
    }*/
    @Pointcut("execution(* com.dream.spring.manager.AspectJManager.show(String))&& args(name)")
    public void performanceArgs(String name){}

    @Around("performanceArgs(name)")
    public void aroundShow(ProceedingJoinPoint joinPoint, String name) {
        try{
            System.out.println("before*name-----:*"+ name);
            // 环绕通知时，必须执行proceed()方法
            joinPoint.proceed();
            System.out.println("after**");
        } catch (Throwable e){
            System.out.println("error**");
        }

    }



}
