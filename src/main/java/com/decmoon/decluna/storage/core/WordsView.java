package com.decmoon.decluna.storage.core;


import com.decmoon.decluna.storage.word.Translate;
import com.decmoon.decluna.storage.word.Word;
import com.decmoon.shortcut.argument.Arguments;
import com.decmoon.shortcut.collection.list.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
/**
 * @author decmoon
 */
public class WordsView {

    public static Set<Word> getUnmodifiableWords() {
        return Words.getUnmodifiableWords();
    }

    public static List<Word> getSortUnmodifiableWords() {
        Set<Word> unmodifiableWords = getUnmodifiableWords();
        List<Word> list = Lists.newArrayList();
        for (Word unmodifiableWord : unmodifiableWords){
            list.add(unmodifiableWord);
        }
        list.sort(Comparator.comparing(Word::getWord));
        return list;
    }

    public static Word getWord(String wordName) {
        for (Word word : getUnmodifiableWords()){
            if (wordName.equalsIgnoreCase(word.getWord())){
                return word;
            }
        }
        return null;
    }

    public static List<Translate> getTranslate(String wordName) {
        return Arguments.parameterLegal(getWord(wordName)) ?
                getWord(wordName).getTranslations() : null;
    }


}
