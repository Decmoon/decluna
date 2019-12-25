package com.decmoon.decluna.storage.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.decmoon.shortcut.argument.Arguments;
import com.decmoon.shortcut.exception.ExceptionLogger;
import com.decmoon.shortcut.file.BufferedReaderGenerator;
import com.decmoon.shortcut.file.FileReaderGenerator;
import com.decmoon.shortcut.file.Files;
import com.decmoon.shortcut.string.Strings;
import lombok.NonNull;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author decmoon
 */
public class Jsons {


    private Jsons() {
    }

    public static JSONObject newJSONObject() {
        return new JSONObject();
    }

    public static JSONObject newLinkedJSONObject() {
        return new JSONObject(true);
    }

    public static JSONArray newJSONArray() {
        return new JSONArray();
    }

    public static void put(JSONObject jsonObject, String key, String value) {
        if (Arguments.parameterLegal(jsonObject, key, value)) {
            jsonObject.put(key, value);
        } else {
            ExceptionLogger.parameterErr(Jsons.class, "put(JSONObject jsonObject, String key, String value)");
        }

    }

    public static void add(JSONArray jsonArray, Object object) {
        if (Arguments.parameterLegal(jsonArray, object)) {
            jsonArray.add(object);
        } else {
            ExceptionLogger.parameterErr(Jsons.class, "add(JSONArray jsonArray, Object object)");
        }
    }


    public static void add(JSONArray jsonArray, @NonNull Object... objects) {
        for (Object object : objects) {
            add(jsonArray, object);
        }
    }


    public static JSONObject getJsonFromFile(String path) {
        String effectivePath = Jsons.class.getResource(path).getPath();
        if (Arguments.parameterLegal(effectivePath)) {
            try (BufferedReader bufferedReader = BufferedReaderGenerator.newBufferedReader(FileReaderGenerator.newFileReader(Files.newFile(effectivePath)));) {
                String s;
                StringBuilder stringBuilder = Strings.newStringBuilder();
                while ((s = bufferedReader.readLine()) != null) {
                    stringBuilder.append(s);
                }
                return (JSONObject) JSON.parse(stringBuilder.toString());
            } catch (IOException e) {
                ExceptionLogger.parameterErr(Jsons.class, "getJsonFromFile(String path)", e);
            }
        } else {
            ExceptionLogger.parameterErr(Jsons.class, "getJsonFromFile(String path)", "path not exist");
        }

        return null;
    }


}
