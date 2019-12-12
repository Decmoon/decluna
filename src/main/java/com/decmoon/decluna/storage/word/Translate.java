package com.decmoon.decluna.storage.word;

import lombok.Data;


/**
 * @author decmoon
 */
@Data
public class Translate {

    private String wordClass;
    private String wordTranslations;

    public Translate(String wordClass, String wordTranslations) {
        this.wordClass = wordClass;
        this.wordTranslations = wordTranslations;
    }
}
