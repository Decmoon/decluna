package com.decmoon.decluna.storage.sentence.english;

import com.decmoon.shortcut.math.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author decmoon
 */
public class Joke {

    private static List<String> list = new ArrayList<>();

    private Joke() {
    }

    static {
        list.add("Nevertrouble trouble till trouble troubles you");
        list.add("I know. You know. I know that you know. I know that you know that I know");
        list.add("I think that that that that that student wrote on the blackboard was wrong");
        list.add("We must hang together, or we'll be hanged separately");
        list.add("The quick brown fox jumps over a lazy dog");
        list.add(" Was it a bar or a bat I saw?");
        list.add("He never saw a saw saw a saw");
        list.add("2B or not 2B, that is a ?");

    }

    public static String joke() {
        return list.get(RandomNumberGenerator.random(0, list.size()));
    }
}
