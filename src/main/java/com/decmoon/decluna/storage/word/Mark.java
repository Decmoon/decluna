package com.decmoon.decluna.storage.word;

/**
 * @author decmoon
 */
public class Mark {


    public static final String REGEXP_WORD_TRANSLATION_SEPARATOR = "\\:";
    public static final String REGEXP_TRANSLATION_SEPARATOR = "\\^";
    public static final String REGEXP_CLASS_TRANSLATION_SEPARATOR = "\\*";
    public static final String REGEXP_MEAN_MEAN_SEPARATOR = "\\;";
    public static final String WORD_TRANSLATION_SEPARATOR = ":";
    public static final String TRANSLATION_SEPARATOR = "^";
    public static final String CLASS_TRANSLATION_SEPARATOR = "*";


    private Mark() {
    }

    public static final String MEAN_MEAN_SEPARATOR = EnglishMark.SEMICOLON;


    public static class ChineseMark {
        public static final String SEMICOLON = "；";
        public static final String COMMA = "，";
        public static final String PERIOD = "。";
        public static final String LEFT_BRACKET = "（";
        public static final String RIGHT_BRACKET = "）";
        public static final String ELLIPSIS = "…";
        public static final String EXCLAMATION = "！";

        private ChineseMark() {
        }
    }

    public static class EnglishMark {
        public static final String SEMICOLON = ";";
        public static final String COMMA = ",";
        public static final String PERIOD = ".";
        public static final String LEFT_BRACKET = "(";
        public static final String RIGHT_BRACKET = ")";
        public static final String ELLIPSIS = "...";
        public static final String EXCLAMATION = "!";

        private EnglishMark() {
        }
    }
}
