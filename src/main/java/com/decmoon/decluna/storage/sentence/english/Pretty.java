package com.decmoon.decluna.storage.sentence.english;

import com.alibaba.fastjson.JSONObject;
import com.decmoon.decluna.storage.sentence.HandOut;
import com.decmoon.decluna.storage.utils.Jsons;
import com.decmoon.shortcut.math.RandomNumberGenerator;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author decmoon
 */
public class Pretty {

    private static final String PATH = "/static/framework/decluna/config/sentence/english/pretty.json";

    private static final JSONObject JSON;

    private static final List<String> LIST;

    static {
        JSON = Jsons.getJsonFromFile(PATH);
        LIST = HandOut.distribution(JSON);
    }

    private Pretty() {
    }


    public static String pretty() {
        return LIST.get(RandomNumberGenerator.random(0, LIST.size()));
    }
}
