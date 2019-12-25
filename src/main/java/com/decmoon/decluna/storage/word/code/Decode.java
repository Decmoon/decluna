package com.decmoon.decluna.storage.word.code;

import com.decmoon.decluna.storage.word.Mark;
import com.decmoon.decluna.storage.word.Translate;
import com.decmoon.decluna.storage.word.Word;
import com.decmoon.shortcut.collection.list.Lists;
import com.decmoon.shortcut.string.StringProcessor;

import java.util.List;

/**
 * @author decmoon
 */
public class Decode {

    private Decode() {
    }

    public static Word decode(String wordName, String string) {
        String[] translateStrings = string.split(Mark.REGEXP_TRANSLATION_SEPARATOR);
        List<Translate> translateList = Lists.newArrayList();
        for (String translateString : translateStrings) {
            String[] split = translateString.split(Mark.REGEXP_CLASS_TRANSLATION_SEPARATOR);
            translateList.add(new Translate(split[0], split[1]));
        }
        return new Word(StringProcessor.INITCAP(wordName), translateList);
    }


    public static Word decode(String stringFromFile) {
        Word word = new Word();
        String[] split = stringFromFile.split(Mark.REGEXP_WORD_TRANSLATION_SEPARATOR);
        String wordName = split[0];
        List<Translate> translateList = Lists.newArrayList();
        for (String translates : split[1].split(Mark.REGEXP_TRANSLATION_SEPARATOR)) {
            String[] arr = translates.split(Mark.REGEXP_CLASS_TRANSLATION_SEPARATOR);
            translateList.add(new Translate(arr[0], arr[1]));
        }
        word.setWordName(wordName);
        word.setTranslations(translateList);
        return word;
    }


}
