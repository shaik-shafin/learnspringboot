package com.shaik.acknowledge.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor1 myInterceptor1;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor1)
                //invoke interceptor for all URL
                .addPathPatterns("/interceptor/*")
                //Do not apply interceptor for this specific URL
                .excludePathPatterns("/interceptor/method2", "/interceptor/method3");

        registry.addInterceptor(getMyInterceptor2())
                //invoke interceptor for all URL
                .addPathPatterns("/interceptor/*")
                //Do not apply interceptor for this specific URL
                .excludePathPatterns("/interceptor/method2", "/interceptor/method3");
    }

    @Bean
    public MyInterceptor2 getMyInterceptor2() {
        return new MyInterceptor2();
    }
}
