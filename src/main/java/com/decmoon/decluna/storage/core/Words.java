package com.decmoon.decluna.storage.core;


import com.decmoon.decluna.storage.io.WordsMemory;
import com.decmoon.decluna.storage.word.Word;
import com.decmoon.shortcut.log.Logger;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/**
 * @author decmoon
 */
@Configuration
public class Words {

    private static Set<Word> words;

    static {
        Logger.log("Words  initializing ");
        words = WordsMemory.load();
    }

    private static Set<Word> getWords() {
        return words;
    }

    private static Word getWord(String wordName) {
        for (Word word : words) {
            if (word.getWord().equals(wordName)) {
                return word;
            }
        }
        return null;
    }

    public static Set<Word> getUnmodifiableWords() {
        return Collections.unmodifiableSet(getWords());
    }


    public static void addWord(Word word) {
        words.add(word);
        WordsMemory.flush();
    }

    public static void addWord(Word... words) {
        for (Word word : words) {
            addWord(word);
        }
    }

    public static void delWord(String worldName) {
        for (Word word : getWords()) {
            if (word.getWord().equals(worldName)) {
                words.remove(word);
                break;
            }
        }
    }

    public static void delWords(String... worldNames) {
        for (String worldName : worldNames) {
            delWord(worldName);
        }
    }

}
