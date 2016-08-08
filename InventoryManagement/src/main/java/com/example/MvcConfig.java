package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by sumi on 1/8/16.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
//        registry.addViewController("/home").setViewName("../static/home");
//        registry.addViewController("/").setViewName("../static/home");
//        registry.addViewController("/hello").setViewName("../static/hello");
//        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/inde").setViewName("../static/inde");
          registry.addViewController("/").setViewName("../static/welcome");
          registry.addViewController("/login").setViewName("login");
    }
}