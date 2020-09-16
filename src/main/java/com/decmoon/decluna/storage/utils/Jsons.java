package com.decmoon.decluna.storage.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.decmoon.shortcut.argument.Arguments;
import com.decmoon.shortcut.exception.argument.ParameterIllegalException;
import com.decmoon.shortcut.exception.io.file.FileNotConnectException;
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
        if (Arguments.parameterLegal(false,Arguments.asList( key, value))) {
            jsonObject.put(key, value);
        } else {
           throw new ParameterIllegalException();
        }

    }

    public static void add(JSONArray jsonArray, Object object) {
        if (Arguments.parameterLegal(Arguments.asList(jsonArray, object))) {
            jsonArray.add(object);
        } else {
            throw new ParameterIllegalException();
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
            try {
                BufferedReader bufferedReader = BufferedReaderGenerator.newBufferedReader(FileReaderGenerator.newFileReader(Files.newFile(effectivePath)));
                String s;
                StringBuilder stringBuilder = Strings.newStringBuilder();
                while ((s = bufferedReader.readLine()) != null) {
                    stringBuilder.append(s);
                }
                return (JSONObject) JSON.parse(stringBuilder.toString());
            } catch (IOException e) {
                try {
                    throw new FileNotConnectException();
                } catch (FileNotConnectException e1) {
                    e1.shutdown();
                }
            }

        } else {
            try {
                throw new ParameterIllegalException();
            } catch (ParameterIllegalException e) {
                e.shutdown();
            }
        }

        return null;
    }


}
