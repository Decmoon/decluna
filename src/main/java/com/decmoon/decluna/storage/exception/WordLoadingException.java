package com.decmoon.decluna.storage.exception;

import com.decmoon.shortcut.exception.ShortCutException;

public class WordLoadingException extends ShortCutException {

    public WordLoadingException() {
        super(WordLoadingException.class, "Word loading failure ,error happened");
    }
}
