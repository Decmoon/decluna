package com.decmoon.decluna.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Map;

/**
 * View parser and interceptor configuration
 *
 * @author decmoon
 * @see Decluna
 */
@Configuration
public class DeclunaWebConfigurer extends Decluna implements WebMvcConfigurer {


    @Autowired
    private DeclunaInterceptor declunaInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        for (Map.Entry<String, String> en : PAGES.entrySet()) {
            registry.addViewController(en.getKey()).setViewName(en.getValue());
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(declunaInterceptor).addPathPatterns("/**");
    }
}
