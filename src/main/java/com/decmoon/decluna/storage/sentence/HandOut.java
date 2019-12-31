package com.decmoon.decluna.storage.sentence;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.decmoon.shortcut.argument.Arguments;
import com.decmoon.shortcut.collection.list.Lists;

import java.util.List;

/**
 * @author decmoon
 */
public class HandOut {

    private HandOut() {
    }

    public static List<String> distribution(JSONObject jsonObject) {
        List<String> list = Lists.newArrayList();
        for (String movie : Movie.MOVIES) {
            JSONArray sentences = jsonObject.getJSONArray(movie);
            if (Arguments.parameterLegal(sentences)) {
                for (Object sentence : sentences) {
                    list.add(String.valueOf(sentence) + "^---" + movie);
                }
            }
        }
        for (String book : Book.BOOKS) {
            JSONArray sentences = jsonObject.getJSONArray(book);
            if (Arguments.parameterLegal(sentences)) {
                for (Object sentence : sentences) {
                    list.add(String.valueOf(sentence) + "^---" + book);
                }
            }
        }
        return list;
    }


}
