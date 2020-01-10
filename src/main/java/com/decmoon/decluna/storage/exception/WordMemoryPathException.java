package com.decmoon.decluna.storage.exception;

import com.decmoon.shortcut.exception.ShortCutException;

public class WordMemoryPathException extends ShortCutException {

    public WordMemoryPathException() {
        super(WordMemoryPathException.class, "Word memorys path fetch exception");
    }
}
