package com.decmoon.decluna.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.Callable;

/**
 * Page jump controller, deprecated
 * Use {@link com.decmoon.decluna.config.DeclunaWebConfigurer} to replace
 *
 * @author decmoon
 * @see com.decmoon.decluna.config.DeclunaWebConfigurer
 */
@Deprecated
public class IndexController {

    @RequestMapping("/")
    public Callable<String> index() {
        return () -> "index.html";
    }

    @RequestMapping("/contents")
    public Callable<String> contents() {
        return () -> "html/contents.html";
    }

    @RequestMapping("/record")
    public Callable<String> record() {
        return () -> "html/record.html";
    }

    @RequestMapping("/check")
    public Callable<String> check() {
        return () -> "html/check.html";
    }

    @RequestMapping("/lookup")
    public Callable<String> lookup() {
        return () -> "html/lookup.html";
    }

    @RequestMapping("/trick")
    public Callable<String> trick() {
        return () -> "html/trick.html";
    }

    @RequestMapping("/about")
    public Callable<String> about() {
        return () -> "html/about.html";
    }


}
