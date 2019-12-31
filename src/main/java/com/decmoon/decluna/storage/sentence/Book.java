package com.decmoon.decluna.storage.sentence;

import com.decmoon.shortcut.argument.Arguments;
import com.decmoon.shortcut.collection.list.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @author decmoon
 */
public class Book {

    protected static final List<String> BOOKS;

    static {
        BOOKS = addBooks();
    }

    private Book() {
    }

    private static List<String> addBooks(String... books) {
        List<String> list = Lists.newArrayList();
        if (Arguments.parameterLegal(books)) {
            list.addAll(Arrays.asList(books));
        }
        return list;
    }
}
