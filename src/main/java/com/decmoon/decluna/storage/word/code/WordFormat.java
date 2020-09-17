package com.decmoon.decluna.storage.word.code;

import com.decmoon.decluna.storage.word.Mark;
import com.decmoon.shortcut.argument.Arguments;
import com.decmoon.shortcut.string.Strings;

/**
 * @author decmoon
 */
public class WordFormat {

    private WordFormat() {
    }

    public static String format(String translate) {
        if(translate.lastIndexOf("*")+1 == translate.length()){
            return "";
        }
        String crudeTranslate = countriesFormat(translate);
        StringBuilder pureTranslate = Strings.newStringBuilder();
        String str = crudeTranslate.trim();
        String[] means = str.split(Mark.REGEXP_TRANSLATION_SEPARATOR);
        for (String mean : means) {
            String[] split = mean.split(Mark.REGEXP_CLASS_TRANSLATION_SEPARATOR);
            String clazz = split[0];
            String crudeMeans = split[1].trim();
            StringBuilder pureMeansStringBuffer = Strings.newStringBuilder();
            String pureMeans;
            if (mean.contains(Mark.MEAN_MEAN_SEPARATOR)) {
                for (String crudeMean : crudeMeans.split(Mark.REGEXP_MEAN_MEAN_SEPARATOR)) {
                    if (Arguments.parameterLegal(crudeMean.trim())) {
                        pureMeansStringBuffer.append(crudeMean.trim() + Mark.MEAN_MEAN_SEPARATOR);
                    }
                }
                pureMeans = pureMeansStringBuffer.substring(0, pureMeansStringBuffer.length() - 1);
            } else {
                pureMeans = crudeMeans;
            }
            pureTranslate.append(clazz + Mark.CLASS_TRANSLATION_SEPARATOR + pureMeans + Mark.TRANSLATION_SEPARATOR);
        }
        return pureTranslate.substring(0, pureTranslate.length() - 1);
    }


    private static String countriesFormat(String crudeTranslate) {
        if (crudeTranslate.contains(Mark.ChineseMark.SEMICOLON)) {
            crudeTranslate = crudeTranslate.replace(Mark.ChineseMark.SEMICOLON, Mark.EnglishMark.SEMICOLON);
        }
        if (crudeTranslate.contains(Mark.ChineseMark.COMMA)) {
            crudeTranslate = crudeTranslate.replace(Mark.ChineseMark.COMMA, Mark.EnglishMark.COMMA);
        }
        if (crudeTranslate.contains(Mark.ChineseMark.PERIOD)) {
            crudeTranslate = crudeTranslate.replace(Mark.ChineseMark.PERIOD, Mark.EnglishMark.PERIOD);
        }
        if (crudeTranslate.contains(Mark.ChineseMark.LEFT_BRACKET)) {
            crudeTranslate = crudeTranslate.replace(Mark.ChineseMark.LEFT_BRACKET, Mark.EnglishMark.LEFT_BRACKET);
        }
        if (crudeTranslate.contains(Mark.ChineseMark.RIGHT_BRACKET)) {
            crudeTranslate = crudeTranslate.replace(Mark.ChineseMark.RIGHT_BRACKET, Mark.EnglishMark.RIGHT_BRACKET);
        }
        if (crudeTranslate.contains(Mark.ChineseMark.ELLIPSIS)) {
            crudeTranslate = crudeTranslate.replace(Mark.ChineseMark.ELLIPSIS, Mark.EnglishMark.ELLIPSIS);
        }
        if (crudeTranslate.contains(Mark.ChineseMark.EXCLAMATION)) {
            crudeTranslate = crudeTranslate.replace(Mark.ChineseMark.EXCLAMATION, Mark.EnglishMark.EXCLAMATION);
        }
        return crudeTranslate;
    }


}
