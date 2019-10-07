package com.yaolong.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author yaoLong
 * @date 2019/10/6  16:56
 * 定义切面拦截
 */

@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.yaolong.web.controller.TestController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("time aspect start");

        long start = System.currentTimeMillis();

        Object[] args = pjp.getArgs();

        for (Object arg : args) {
            System.out.println(arg);
        }
        Object object = pjp.proceed();
        System.out.println("object ClassName:" + object.getClass().getName());
        System.out.println("pjp ClassName:" + pjp.getClass().getName());
        System.out.println("Time Aspect 耗时 :" + (System.currentTimeMillis() - start));
        System.out.println("Time Aspect finish");

        return object;
    }

}
