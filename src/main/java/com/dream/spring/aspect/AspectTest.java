package com.dream.spring.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Controller;

/**
 * Created by ning on 2018/6/30.
 */

@Aspect
public class AspectTest {

    @Pointcut("execution(* com.dream.spring.manager.Manager.show(..))")
    public void performance(){}

    @Before("performance()")
    public void beforeShow() {
            System.out.println("before------------------------------------------------");
    }



}
