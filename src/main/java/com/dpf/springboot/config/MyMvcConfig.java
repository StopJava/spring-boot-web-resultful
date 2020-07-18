package com.dpf.springboot.config;

import com.dpf.springboot.component.MyLocaleResolever;
import com.dpf.springboot.controller.LoginHandleInterceptor;
import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @program:spring-boot-web-resultful
 * @description:
 * @autor:dpf
 * @create:2020-07-10 21:50
 **/
//使用WebMvcConfigurer扩展springmvc的功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandleInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login","/asserts/**","/webjars/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/nice").setViewName("success");
    }
    //视图映射器
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
        };
        return configurer;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolever();
    }
}
