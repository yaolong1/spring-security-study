package com.yaolong.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yaoLong
 * @date 2019/10/6  16:08
 * 定义拦截器
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("interceptor preHandle init");

        System.out.println(((HandlerMethod) handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod) handler).getMethod().getName());
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle");
        long start = (Long) request.getAttribute("startTime");
        System.out.println("Time postHandle Interceptor 耗时 :" + (System.currentTimeMillis() - start));

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("ex is:" + ex);
        System.out.println("afterCompletion");
        long start = (Long) request.getAttribute("startTime");
        System.out.println("Time afterCompletion Interceptor 耗时 :" + (System.currentTimeMillis() - start));
    }
}
