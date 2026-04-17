package com.xpxp.Config;

/*
 * 😊😊😊😊😊😊😊😊😊😊😊😊
 * @file WebMvcConfiguration
 * @author thexpxp233
 * @date 2025/11/20
 * My name is lixiaopei
 **/

import com.xpxp.interceptor.AuthenticationInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        /*添加拦截器*/
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/user/**","/admin/**")
                .excludePathPatterns("/user/login",
                        "/doc.html/**",
                        "/webjars/**",
                        "/v3/**",
                        "swagger-resources/**",
                        "/swagger-ui/**",
                        "/favicon.ico",
                        "/.well-known/**",
                        "/user/flower/**",
                        "/user/category/**"
                );
    }
}