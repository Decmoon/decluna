package com.decmoon.decluna.service.page;

import com.alibaba.fastjson.JSONObject;
import com.decmoon.decluna.storage.core.Words;
import com.decmoon.decluna.storage.sentence.english.Pretty;
import com.decmoon.decluna.storage.status.Status;
import com.decmoon.decluna.storage.utils.Jsons;
import com.decmoon.decluna.storage.word.Word;
import com.decmoon.decluna.storage.word.code.Check;
import com.decmoon.decluna.storage.word.code.Decode;
import com.decmoon.decluna.storage.word.code.WordFormat;
import org.springframework.stereotype.Service;

/**
 * @author decmoon
 */
@Service
public class RecordService {


    public JSONObject add(String wordName, String crudeTranslate) {
        JSONObject data = Jsons.newLinkedJSONObject();
        String translate = WordFormat.format(crudeTranslate);
        Status status;
        if (Check.codeLegal(wordName, translate)) {
            status = Status.OKAY;
            Word word = Decode.decode(wordName, translate);
            System.out.println(word);
            Words.addWord(word);
            Jsons.put(data, "pretty", Pretty.pretty());
        } else {
            status = Status.NO;
        }
        Jsons.put(data, status.getKey(), status.getValue());
        return data;
    }
}
