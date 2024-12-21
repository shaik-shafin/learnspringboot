package com.shaik.acknowledge.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyFilter1 myFilter1() {
        return new MyFilter1();
    }

    @Bean
    public MyFilter2 myFilter2() {
        return new MyFilter2();
    }


    @Bean
    public FilterRegistrationBean<MyFilter1> myFilter1Registration() {
        FilterRegistrationBean<MyFilter1> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(myFilter1());
        registrationBean.addUrlPatterns("/api/myfilter1", "/api/myfilter2");
        registrationBean.setOrder(2);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter2> myFilter2Registration() {
        FilterRegistrationBean<MyFilter2> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(myFilter2());
        registrationBean.addUrlPatterns("/api/myfilter1");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
