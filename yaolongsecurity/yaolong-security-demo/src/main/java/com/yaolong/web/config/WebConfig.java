package com.yaolong.web.config;

import com.yaolong.interceptor.TimeInterceptor;
import com.yaolong.web.filter.TimeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaoLong
 * @date 2019/10/6  15:56
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    TimeInterceptor timeInterceptor;

    /**
     * 注册过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean timeFilter(){

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();

        //注册TimeFilter过滤器
        registrationBean.setFilter(timeFilter);

        //设置过滤器的生效的路径
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);

        return registrationBean;
    }


    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }
}
