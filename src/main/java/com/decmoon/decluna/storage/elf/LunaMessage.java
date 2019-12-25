package com.decmoon.decluna.storage.elf;
/**
 * @author decmoon
 */
public class LunaMessage{

    private LunaMessage(){}

    public static String getMessage(String lunaCode) {
        String lunaGroup = lunaCode.substring(0, lunaCode.lastIndexOf('-'));
        return LunaConfig.getMESSAGE().getString(lunaGroup);
    }

}
