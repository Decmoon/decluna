package com.decmoon.decluna.storage.word.code;

import com.decmoon.decluna.storage.word.Mark;
import com.decmoon.shortcut.argument.Arguments;
/**
 * @author decmoon
 */
public class Check {

    public static boolean codeLegal(String codeName, String translate) {
        if (Arguments.parameterLegal(codeName, translate)) {
            if (!translate.contains(Mark.TRANSLATION_SEPARATOR)) {
                return hasTranslate_only(translate);
            }else{
                return hasTranslate_multiple(translate);
            }
        }
        return false;
    }


    private static boolean hasTranslate_only(String translate) {
        if (translate.contains(Mark.CLASS_TRANSLATION_SEPARATOR)) {
            String[] split = translate.split(Mark.RegExp_CLASS_TRANSLATION_SEPARATOR);
            if (split.length == 2){
                if (Arguments.parameterLegal(split[0], split[1])){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasTranslate_multiple(String translate) {
        String[] split = translate.split(Mark.RegExp_TRANSLATION_SEPARATOR);
        boolean b = true;
        for (String s : split) {
            if (!hasTranslate_only(s)) {
                b = false;
                break;
            }
        }
        return b;
    }
}
