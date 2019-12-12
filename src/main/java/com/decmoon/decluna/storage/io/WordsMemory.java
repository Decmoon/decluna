package com.decmoon.decluna.storage.io;

import com.decmoon.decluna.storage.core.WordsView;
import com.decmoon.decluna.storage.word.Word;
import com.decmoon.decluna.storage.word.code.Decode;
import com.decmoon.decluna.storage.word.code.Encryption;
import com.decmoon.shortcut.collection.set.Sets;
import com.decmoon.shortcut.exception.ExceptionLogger;
import com.decmoon.shortcut.file.*;
import com.decmoon.shortcut.log.Logger;
import com.decmoon.shortcut.string.Strings;
import com.decmoon.shortcut.string.ToString;

import java.io.*;
import java.nio.file.Path;
import java.util.Set;
/**
 * There is an IO stream of word profiles
 * @author decmoon
 */
public class WordsMemory {
    private static final String NAME = "word_memory.decluna";
    private static final String PATH = WordsMemory.class.getResource("/static/framework/decluna/config/words/" +NAME).getPath();

    static {
        Logger.log("WordsMemory  initializing ");
    }

    public static Set<Word> load() {
        Set<Word> words = Sets.newHashSet();
        try (
                FileReader fileReader = FileReaderGenerator.newFileReaderWithThrows(Files.newFile(PATH));
                BufferedReader bufferedReader = BufferedReaderGenerator.newBufferedReader(fileReader);
        ) {
            String s;
            while ((s = DocumentReadingFactory.readingLineWithThrows(bufferedReader)) != null){
                words.add(Decode.decode(s));
            }
            Logger.log("WordsMemory  file load the success ");
        } catch (FileNotFoundException e) {
            ExceptionLogger.parameterErr(WordsMemory.class, "load()", e);
        } catch (IOException e) {
            ExceptionLogger.parameterErr(WordsMemory.class, "load()", e);
        }
        return words;
    }

    private static String textFromFlush() {
        StringBuffer stringBuffer = Strings.newStringBuffer();
        for (Word word : WordsView.getUnmodifiableWords())
            stringBuffer.append(Encryption.encryption(word) + "\n");
        return ToString.toString(stringBuffer);
    }

    public static void flush() {
        try (
                FileWriter fileWriter = FileWriterGenerator.newFileWriterWithThrows(Files.newFile(PATH), true);
                BufferedWriter bufferedWriter = BufferedWriterGenerator.newBufferedWriter(fileWriter);
        ) {
            DocumentPrintingFactory.typewritingWithThrows(bufferedWriter,textFromFlush());
        } catch (FileNotFoundException e) {
            ExceptionLogger.parameterErr(WordsMemory.class, "flush()", e);
        } catch (IOException e) {
            ExceptionLogger.parameterErr(WordsMemory.class, "flush()", e);
        }


    }

}
