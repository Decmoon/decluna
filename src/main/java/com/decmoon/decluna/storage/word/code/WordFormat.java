package com.decmoon.decluna.storage.word.code;

import com.decmoon.decluna.storage.word.Mark;
import com.decmoon.shortcut.argument.Arguments;
import com.decmoon.shortcut.string.Strings;
/**
 * @author decmoon
 */
public class WordFormat {

    public static String format(String translate) {
        String crudeTranslate = countriesFormat(translate);
        StringBuffer pureTranslate = Strings.newStringBuffer();
        String str = crudeTranslate.trim();
        String[] means = str.split(Mark.RegExp_TRANSLATION_SEPARATOR);
        for (String mean : means) {
            String[] split = mean.split(Mark.RegExp_CLASS_TRANSLATION_SEPARATOR);
            String clazz = split[0];
            String crudeMeans = split[1].trim();
            StringBuffer pureMeansStringBuffer = Strings.newStringBuffer();
            String pureMeans;
            if (mean.contains(Mark.MEAN_MEAN_SEPARATOR)) {
                for (String crudeMean : crudeMeans.split(Mark.RegExp_MEAN_MEAN_SEPARATOR)) {
                    if (Arguments.parameterLegal(crudeMean.trim())) {
                        pureMeansStringBuffer.append(crudeMean.trim() + Mark.MEAN_MEAN_SEPARATOR);
                    }
                }
                pureMeans = pureMeansStringBuffer.substring(0, pureMeansStringBuffer.length() - 1);
            } else{
                pureMeans = crudeMeans;
            }
            pureTranslate.append(clazz + Mark.CLASS_TRANSLATION_SEPARATOR + pureMeans + Mark.TRANSLATION_SEPARATOR);
        }
        return pureTranslate.substring(0, pureTranslate.length() - 1);
    }


    private static String countriesFormat(String crudeTranslate) {
        if (crudeTranslate.contains(Mark.ChineseMark.semicolon)) {
            crudeTranslate = crudeTranslate.replace(Mark.ChineseMark.semicolon, Mark.EnglishMark.semicolon);
        }
        if (crudeTranslate.contains(Mark.ChineseMark.comma)){
            crudeTranslate = crudeTranslate.replace(Mark.ChineseMark.comma, Mark.EnglishMark.comma);
        }
        if (crudeTranslate.contains(Mark.ChineseMark.period)){
            crudeTranslate = crudeTranslate.replace(Mark.ChineseMark.period, Mark.EnglishMark.period);
        }
        if (crudeTranslate.contains(Mark.ChineseMark.leftBracket)){
            crudeTranslate = crudeTranslate.replace(Mark.ChineseMark.leftBracket, Mark.EnglishMark.leftBracket);
        }
        if (crudeTranslate.contains(Mark.ChineseMark.rightBracket)){
            crudeTranslate = crudeTranslate.replace(Mark.ChineseMark.rightBracket, Mark.EnglishMark.rightBracket);
        }
        if (crudeTranslate.contains(Mark.ChineseMark.ellipsis)){
            crudeTranslate = crudeTranslate.replace(Mark.ChineseMark.ellipsis, Mark.EnglishMark.ellipsis);
        }
        if (crudeTranslate.contains(Mark.ChineseMark.exclamation)){
            crudeTranslate = crudeTranslate.replace(Mark.ChineseMark.exclamation, Mark.EnglishMark.exclamation);
        }
        return crudeTranslate;
    }



}
