package com.decmoon.decluna.storage.elf;
/**
 * @author decmoon
 */
public class LunaMessage extends LunaConfig {

    public static String getMessage(String lunaCode) {
        String lunaGroup = lunaCode.substring(0, lunaCode.lastIndexOf("-"));
        return MESSAGE.getString(lunaGroup);
    }

}
