package com.decmoon.decluna;

import com.decmoon.decluna.config.DecLunaAspect;
import com.decmoon.decluna.config.Decluna;
import com.decmoon.shortcut.core.annotation.EnableShortcutAspect;
import com.decmoon.shortcut.core.annotation.EnableShortcutLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author decmoon
 */
@SpringBootApplication
@EnableShortcutLogger
@EnableShortcutAspect(aspect = DecLunaAspect.class)
public class DeclunaApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DeclunaApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DeclunaApplication.class, args);
    }

}
