package com.maamcare.bmi.config;

import com.maamcare.bmi.component.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginHandlerInterceptor repeatInterceptor;
    /**
     * 全局拦截器
     * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(repeatInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/user/login","/user/noLogin");
    }


}
