package com.decmoon.decluna.storage.word.code;

import com.decmoon.decluna.storage.word.Mark;
import com.decmoon.decluna.storage.word.Translate;
import com.decmoon.decluna.storage.word.Word;
import com.decmoon.shortcut.string.Strings;
import com.decmoon.shortcut.string.ToString;

import java.util.List;
/**
 * @author decmoon
 */
public class Encryption {

    public static String encryption(Word word) {
        String wordName = word.getWord();
        String translateString = encryption(word.getTranslations());
        return ToString.toString(wordName, Mark.WORD_TRANSLATION_SEPARATOR, translateString);
    }



    private static String encryption(List<Translate> translates) {
        StringBuffer stringBuffer = Strings.newStringBuffer();
        for (Translate translate : translates) {
            stringBuffer.append(translate.getWordClass() + Mark.CLASS_TRANSLATION_SEPARATOR + translate.getWordTranslations() + Mark.TRANSLATION_SEPARATOR);
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1);
    }




}
