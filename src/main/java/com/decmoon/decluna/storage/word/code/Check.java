package com.decmoon.decluna.storage.word.code;

import com.decmoon.decluna.storage.word.Mark;
import com.decmoon.shortcut.argument.Arguments;


/**
 * @author decmoon
 */
public class Check {

    private Check() {
    }

    public static boolean codeLegal(String codeName, String translate) {
        if (Arguments.parameterLegal(Arguments.asList(codeName, translate))) {
            if (!translate.contains(Mark.TRANSLATION_SEPARATOR)) {
                return hasTranslateOnly(translate);
            } else {
                return hasTranslateMultiple(translate);
            }
        }
        return false;
    }


    private static boolean hasTranslateOnly(String translate) {
        if (translate.contains(Mark.CLASS_TRANSLATION_SEPARATOR)) {
            String[] split = translate.split(Mark.REGEXP_CLASS_TRANSLATION_SEPARATOR);
            if (split.length == 2 && Arguments.parameterLegal(Arguments.asList(split[0], split[1]))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasTranslateMultiple(String translate) {
        String[] split = translate.split(Mark.REGEXP_TRANSLATION_SEPARATOR);
        boolean b = true;
        for (String s : split) {
            if (!hasTranslateOnly(s)) {
                b = false;
                break;
            }
        }
        return b;
    }
}
