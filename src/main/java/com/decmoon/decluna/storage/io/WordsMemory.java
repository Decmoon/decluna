package com.decmoon.decluna.storage.io;

import com.decmoon.decluna.storage.core.WordsView;
import com.decmoon.decluna.storage.exception.WordLoadingException;
import com.decmoon.decluna.storage.word.Word;
import com.decmoon.decluna.storage.word.code.Decode;
import com.decmoon.decluna.storage.word.code.Encryption;
import com.decmoon.shortcut.argument.Arguments;
import com.decmoon.shortcut.collection.list.Lists;
import com.decmoon.shortcut.collection.set.Sets;
import com.decmoon.shortcut.exception.ExceptionLogger;
import com.decmoon.shortcut.file.*;
import com.decmoon.shortcut.log.Logger;
import com.decmoon.shortcut.string.Strings;
import com.decmoon.shortcut.string.ToString;
import lombok.Getter;

import java.io.*;
import java.util.List;
import java.util.Set;

/**
 * There is an IO stream of word profiles
 *
 * @author decmoon
 */
public class WordsMemory {
    @Getter
    private static final String NAME = "word_memory.decluna";
    @Getter
    private static final String PATH = WordsMemory.class.getResource("/static/framework/decluna/config/words/" + NAME).getPath();

    static {
        Logger.log("WordsMemory  initializing ");
    }

    private WordsMemory() {
    }

    public static Set<Word> load() throws WordLoadingException {
        Set<Word> words = Sets.newHashSet();
        try (
                FileReader fileReader = FileReaderGenerator.newFileReaderWithThrows(Files.newFile(PATH));
                BufferedReader bufferedReader = BufferedReaderGenerator.newBufferedReader(fileReader);
        ) {
            String s;
            List<Word> wordList = Lists.newArrayList();
            while ((s = DocumentReadingFactory.readingLineWithThrows(bufferedReader)) != null) {
                Word word = Decode.decode(s);
                if (Arguments.parameterLegal(word)) {
                    wordList.add(word);
                } else {
                    throw new IOException();
                }
            }
            wordList.forEach(word->words.add(word));
            Logger.log("WordsMemory  file load the success ");
        } catch (IOException e) {
            ExceptionLogger.parameterErr(WordsMemory.class, "load()","error happened");
            throw new WordLoadingException();
        }
        return words;
    }

    private static String textFromFlush() {
        StringBuilder stringBuilder = Strings.newStringBuilder();
        for (Word word : WordsView.getUnmodifiableWords()){
            stringBuilder.append(Encryption.encryption(word) + "\n");
        }
        return ToString.toString(stringBuilder);
    }

    public static void flush() {
        try (
                FileWriter fileWriter = FileWriterGenerator.newFileWriterWithThrows(Files.newFile(PATH), true);
                BufferedWriter bufferedWriter = BufferedWriterGenerator.newBufferedWriter(fileWriter);
        ) {
            DocumentPrintingFactory.typewritingWithThrows(bufferedWriter, textFromFlush());
        } catch (IOException e) {
            ExceptionLogger.parameterErr(WordsMemory.class, "flush()", e);
        }


    }

}
