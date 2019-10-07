package com.yaolong.web.filter;


import javax.servlet.*;
import java.io.IOException;
import java.sql.Date;


/**
 * @author yaoLong
 * @date 2019/10/6  15:41
 *
 * 配置过滤器(请求不到spring内部的controller的方法信息)
 */
//@Component
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("Time filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Time filter start");
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        System.out.println("Time filter 耗时 :" + (System.currentTimeMillis() - start));
        System.out.println("Time filter finish");


    }

    @Override
    public void destroy() {
        System.out.println("Time filter destroy");
    }
}
