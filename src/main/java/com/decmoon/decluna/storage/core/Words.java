package com.decmoon.decluna.storage.core;


import com.decmoon.decluna.storage.exception.WordLoadingException;
import com.decmoon.decluna.storage.io.WordsMemory;
import com.decmoon.decluna.storage.word.Word;
import com.decmoon.shortcut.exception.ExceptionLogger;
import com.decmoon.shortcut.log.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author decmoon
 */
public class Words {

    private static Set<Word> wordsContainer;

    static {
        Logger.log("Words  initializing ");
        wordsContainer = WordsMemory.load();
    }

    private Words() {
    }

    private static Set<Word> getWords() {
        return wordsContainer;
    }

    public static Set<Word> getUnmodifiableWords() {
        return Collections.unmodifiableSet(getWords());
    }


    public static void addWord(Word word) {
        if (wordsContainer.contains(word)) {
            wordsContainer.remove(word);
        }
        wordsContainer.add(word);
        WordsMemory.flush();
    }

    public static void addWord(Word... words) {
        for (Word word : words) {
            addWord(word);
        }
    }

    public static void addWord(List<Word> list) {
        for (Word word : list) {
            addWord(word);
        }
    }

    public static void deleteWord(String worldName) {
        for (Word word : getWords()) {
            if (word.getWordName().equals(worldName)) {
                wordsContainer.remove(word);
                break;
            }
        }
    }

    public static void deleteWords(String... worldNames) {
        for (String worldName : worldNames) {
            deleteWord(worldName);
        }
    }

    public static void fileImport() {
        wordsContainer = WordsMemory.load();
    }
}
