package com.decmoon.decluna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author decmoon
 */
@SpringBootApplication
public class DeclunaApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DeclunaApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DeclunaApplication.class, args);
    }

}
