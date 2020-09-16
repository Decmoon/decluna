package com.decmoon.decluna.storage.elf;

import com.decmoon.shortcut.argument.Arguments;
import com.decmoon.shortcut.collection.list.Lists;
import com.decmoon.shortcut.core.log.Console;
import com.decmoon.shortcut.exception.argument.ParameterIllegalException;
import com.decmoon.shortcut.exception.io.file.FileNotConnectException;
import com.decmoon.shortcut.file.Files;

import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 * @author decmoon
 */
public class LunaCode {

    private static final String PATH = LunaCode.class.getResource("/static/framework/decluna/luna/luna_preset/").getPath();
    private static final List<String> LUNA_CODE_LIST;

    static {
        Console.info("LunaCode loading ...");
        LUNA_CODE_LIST = scan(PATH);
    }

    private LunaCode() {
    }

    public static List<String> getLunaCodeList() {
        return Collections.unmodifiableList(LUNA_CODE_LIST);
    }

    public static String getLunaCode(String lunaCode) {
        return LUNA_CODE_LIST.contains(lunaCode) ? lunaCode : null;
    }


    public static List<String> scan(String path) {
        List<String> list = Lists.newArrayList();
        File file = new File(path);
        if (Files.isDirectory(file)) {
            for (File f : file.listFiles()) {
                list.add(f.getName());
            }
        }
        if (Arguments.parameterIllegal(list)) {
            throw new FileNotConnectException();
        } else {
            Console.info("LunaCode loaded successfully ...");
        }
        return list;
    }


}
