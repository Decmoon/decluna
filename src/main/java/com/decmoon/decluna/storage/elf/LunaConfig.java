package com.decmoon.decluna.storage.elf;

import com.alibaba.fastjson.JSONObject;
import com.decmoon.decluna.storage.utils.Jsons;
/**
 * @author decmoon
 */
public class LunaConfig {

    public static final String PATH = "/static/framework/decluna/luna/luna_preset/";

    private static final String JSON_MESSAGE_PATH = "/static/framework/decluna/luna/config/message.json";
    private static final String JSON_LUNA_TALK_PATH = "/static/framework/decluna/luna/config/luna-talk-en.json";

    public final static JSONObject MESSAGE;
    public final static JSONObject LUNA_TALK;

    static {
        MESSAGE = Jsons.getJsonFromFile(JSON_MESSAGE_PATH);
        LUNA_TALK = Jsons.getJsonFromFile(JSON_LUNA_TALK_PATH);
    }

}
