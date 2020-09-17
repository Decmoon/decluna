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
import com.decmoon.shortcut.collection.CollectionExhibitor;
import com.decmoon.shortcut.core.log.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author decmoon
 */
@Service
public class RecordService {

    public JSONObject add(String wordName, String crudeTranslate) {
//        CollectionExhibitor.see(null);
        JSONObject data = Jsons.newLinkedJSONObject();
        String translate = WordFormat.format(crudeTranslate);
        Status status;
        if (Check.codeLegal(wordName, translate)) {
            wordName = wordName.trim();
            status = Status.OKAY;
            Word word = Decode.decode(wordName, translate);
            Words.addWord(word);
            Jsons.put(data, "pretty", Pretty.pretty());
        } else {
            status = Status.NO;
        }
        Jsons.put(data, status.getKey(), status.getValue());
        return data;
    }

}
