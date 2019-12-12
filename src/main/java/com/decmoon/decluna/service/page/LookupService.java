package com.decmoon.decluna.service.page;

import com.alibaba.fastjson.JSONObject;
import com.decmoon.decluna.storage.core.WordsView;
import com.decmoon.decluna.storage.sentence.english.Joke;
import com.decmoon.decluna.storage.status.Status;
import com.decmoon.decluna.storage.utils.Jsons;
import com.decmoon.decluna.storage.word.Word;
import com.decmoon.decluna.storage.word.code.Encryption;
import com.decmoon.shortcut.argument.Arguments;
import org.springframework.stereotype.Service;

/**
 * @author decmoon
 */
@Service
public class LookupService {


    public JSONObject lookup(String wordName) {
        JSONObject jsonObject = Jsons.newJSONObject();
        Word word = WordsView.getWord(wordName);
        Status status;
        if (Arguments.parameterLegal(word)) {
            status = Status.OKAY;
            String encryption = Encryption.encryption(word);
            Jsons.put(jsonObject, "info", encryption);
        } else {
            status = Status.NO;
            String joke = Joke.joke();
            Jsons.put(jsonObject, "info", joke);
        }
        Jsons.put(jsonObject, status.getKey(), status.getValue());
        return jsonObject;
    }

}
