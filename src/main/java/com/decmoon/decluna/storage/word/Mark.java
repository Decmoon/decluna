package com.decmoon.decluna.storage.word;
/**
 * @author decmoon
 */
public class Mark {
    public final static String RegExp_WORD_TRANSLATION_SEPARATOR = "\\:";
    public final static String RegExp_TRANSLATION_SEPARATOR = "\\^";
    public final static String RegExp_CLASS_TRANSLATION_SEPARATOR = "\\*";
    public final static String RegExp_MEAN_MEAN_SEPARATOR = "\\;";
    public final static String WORD_TRANSLATION_SEPARATOR = ":";
    public final static String TRANSLATION_SEPARATOR = "^";
    public final static String CLASS_TRANSLATION_SEPARATOR = "*";


    public final static String MEAN_MEAN_SEPARATOR = EnglishMark.semicolon;


    public static class ChineseMark {
        public final static String semicolon = "；";
        public final static String comma = "，";
        public final static String period = "。";
        public final static String leftBracket="（";
        public final static String rightBracket="）";
        public final static String ellipsis="…";
        public final static String exclamation="！";
    }

    public static class EnglishMark {
        public final static String semicolon = ";";
        public final static String comma = ",";
        public final static String period = ".";
        public final static String leftBracket="(";
        public final static String rightBracket=")";
        public final static String ellipsis="...";
        public final static String exclamation="!";
    }
}
