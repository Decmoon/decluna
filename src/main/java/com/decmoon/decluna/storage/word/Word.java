package com.decmoon.decluna.storage.word;

import lombok.Data;

import java.util.List;
import java.util.Objects;
/**
 * @author decmoon
 */
@Data
public class Word {

    private String wordName;

    private List<Translate> translations;

    public Word() {
    }

    public Word(String word, List<Translate> translations) {
        this.wordName = word;
        this.translations = translations;
    }

    @Override
    public boolean equals(Object object) {
        return (object instanceof Word && this.wordName.equalsIgnoreCase(((Word) object).getWordName()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordName);
    }
}
