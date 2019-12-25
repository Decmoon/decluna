package com.decmoon.decluna.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Static resource provision
 *
 * @author decmoon
 */
public class Decluna {

    /**
     * Request jump page
     */
    protected static final Map<String, String> PAGES = new HashMap<>();

    static {
        put("/", "index.html");
        put("/contents", "html/contents.html");
        put("/record", "html/record.html");
        put("/check", "html/check.html");
        put("/lookup", "html/lookup.html");
        put("/trick", "html/trick.html");
        put("/about", "html/about.html");
        put("/error", "html/error.html");
    }

    private Decluna() {
    }

    private static void put(String key, String value) {
        PAGES.put(key, value);
    }

}
