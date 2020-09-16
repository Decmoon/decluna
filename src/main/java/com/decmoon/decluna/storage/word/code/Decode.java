package com.decmoon.decluna.storage.word.code;

import com.decmoon.decluna.storage.word.Mark;
import com.decmoon.decluna.storage.word.Translate;
import com.decmoon.decluna.storage.word.Word;
import com.decmoon.shortcut.argument.Arguments;
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
        if (stringFromFile.contains(Mark.WORD_TRANSLATION_SEPARATOR) &&
                stringFromFile.contains(Mark.CLASS_TRANSLATION_SEPARATOR)) {

            String[] split = stringFromFile.split(Mark.REGEXP_WORD_TRANSLATION_SEPARATOR);
            String wordName = split[0];
            String translatesString = split[1];
            if (Arguments.parameterIllegal(Arguments.asList(wordName, translatesString))) {
                return null;
            }
            List<Translate> translateList = Lists.newArrayList();
            for (String translates : translatesString.split(Mark.REGEXP_TRANSLATION_SEPARATOR)) {
                String[] arr = translates.split(Mark.REGEXP_CLASS_TRANSLATION_SEPARATOR);
                translateList.add(new Translate(arr[0], arr[1]));
            }
            Word word = new Word();
            word.setWordName(wordName);
            word.setTranslations(translateList);
            return word;

        }
        return null;

    }


}
