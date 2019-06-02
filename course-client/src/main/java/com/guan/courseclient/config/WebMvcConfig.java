package com.guan.courseclient.config;

/**
 * @author:Guan
 * @date 2019/5/24,17:55
 **/

import com.guan.courseclient.Utils.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/main").setViewName("dashboard");
                registry.addViewController("/404").setViewName("404");
                registry.addViewController("/register").setViewName("register");
                registry.addViewController("/myCourse").setViewName("mydashboard");
            }
        };
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/login", "/","login.html","/static/**","/user/login","/register","register.html",
                "/user/sendEmail","/user/register","/user/findAll","/user/out","user/choose","/user/selection","/404","404.html");

    }
}
