package com.decmoon.decluna.storage.sentence;

import com.decmoon.shortcut.argument.Arguments;
import com.decmoon.shortcut.collection.list.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @author decmoon
 */
public class Movie {

    protected static final List<String> MOVIES;


    static {
        MOVIES = addMovies(
                "Forrest Gump",
                "Shawshank Redemption",
                "The Lion King",
                "Gone with The Wind",
                "TITANIC",
                "Sleepless in Seattle");
    }

    private Movie() {
    }

    private static List<String> addMovies(String... movies) {
        List<String> list = Lists.newArrayList();
        if (Arguments.parameterLegal(movies)) {
            list.addAll(Arrays.asList(movies));
        }
        return list;
    }


}
