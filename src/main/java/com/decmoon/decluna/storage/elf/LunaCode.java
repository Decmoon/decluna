package com.decmoon.decluna.storage.elf;

import com.decmoon.shortcut.argument.Arguments;
import com.decmoon.shortcut.collection.list.Lists;
import com.decmoon.shortcut.exception.ExceptionLogger;
import com.decmoon.shortcut.file.Files;
import com.decmoon.shortcut.log.Logger;

import java.io.File;
import java.util.Collections;
import java.util.List;
/**
 * @author decmoon
 */
public class LunaCode {
    private final static String PATH = LunaCode.class.getResource("/static/framework/decluna/luna/luna_preset/").getPath();
    private final static List<String> LUNACODE;

    static {
        Logger.log("LunaCode loading ...");
        LUNACODE = scan(PATH);
    }


    public static List<String> getLunaCodeList() {
        return Collections.unmodifiableList(LUNACODE);
    }

    public static String getLunaCode(String lunaCode) {
        return LUNACODE.contains(lunaCode) ? lunaCode : null;
    }


    public static List<String> scan(String path) {
        List<String> list = Lists.newArrayList();
        File file = new File(path);
        if (Files.isDirectory(file)){
            for (File f : file.listFiles()){
                list.add(f.getName());
            }
        }
        if (Arguments.parameterIllegal(list)){
            ExceptionLogger.parameterErr(LunaCode.class, "luna preset loading failure");
        }else{
            Logger.log("LunaCode loaded successfully ...");
        }
        return list;
    }


}
