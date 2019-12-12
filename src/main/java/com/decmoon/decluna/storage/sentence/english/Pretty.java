package com.decmoon.decluna.storage.sentence.english;

import com.decmoon.shortcut.math.RandomNumberGenerator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * @author decmoon
 */
@Component
public class Pretty {

    private static List<String> list = new ArrayList<>();

    static {
        list.add("Life was like a box of chocolates, you never know what you're gonna get.^---Forrest Gump");
        list.add("Miracles happen every day.^---Forrest Gump");
        list.add("You know some birds are not meant to be caged, their feathers are just too bright.^---Shawshank Redemption");
        list.add("Yes, the past can hurt.But I think you can either run from it or learn from it.^---The Lion King");
    }

    public static String pretty() {
        return list.get(RandomNumberGenerator.random(0,list.size()));
    }

}
