package com.decmoon.decluna.config;

import com.decmoon.shortcut.core.log.Console;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Decluna's interceptor, custom error interface
 *
 * @author decmoon
 * @see Decluna
 */
@Configuration
public class DeclunaInterceptor implements HandlerInterceptor {

    static {
        Console.info("DeclunaInterceptor initializing");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURL = request.getRequestURL().toString();
        boolean is = urlEquals(requestURL, Decluna.PAGES) || urlContains(requestURL, "/elf/", "/word/", "/css/", "index.html", "/framework/", "/html/", "/image/", "/js/");
        if (is) {
            return true;
        } else {
            response.sendRedirect("/error");
        }
        return false;
    }


    private boolean urlContains(String url, String... paths) {
        boolean is = false;
        for (String path : paths) {
            if (url.contains(path)) {
                is = true;
                break;
            }
        }
        return is;
    }

    private boolean urlEquals(String url, Map<String, String> map) {
        boolean is = false;
        String u = url.substring(url.lastIndexOf('/'));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(u)) {
                is = true;
                break;
            }
        }
        return is;
    }
}
