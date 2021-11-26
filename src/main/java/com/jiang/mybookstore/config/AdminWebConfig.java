package com.jiang.mybookstore.config;

import com.jiang.mybookstore.interceptor.ManagerLoginInterceptor;
import com.jiang.mybookstore.interceptor.UserLoginInterceptor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器注册到容器中 && 指定拦截规则
 * @author jiang
 * @create 2021-11-25-5:01 下午
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginInterceptor())//拦截器注册到容器中
            .addPathPatterns("/loginSuccess","/registSuccess",
                "/checkoutPage","/myOrderPage");
        registry.addInterceptor(new ManagerLoginInterceptor())
            .addPathPatterns("/bookPage","/bookEdit","/book/**","/showAllOrdersPage");
    }




}
