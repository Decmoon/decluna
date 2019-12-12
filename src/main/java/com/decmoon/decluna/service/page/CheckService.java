package com.decmoon.decluna.service.page;

import com.alibaba.fastjson.JSONObject;
import com.decmoon.decluna.storage.status.Status;
import com.decmoon.decluna.storage.utils.Jsons;
import com.decmoon.decluna.storage.word.Translate;
import com.decmoon.decluna.storage.word.Word;
import com.decmoon.decluna.storage.core.WordsView;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.decmoon.decluna.storage.utils.Jsons.put;

/**
 * @author decmoon
 */
@Service
public class CheckService {


    public JSONObject check() {
        JSONObject data = Jsons.newLinkedJSONObject();
        List<Word> unmodifiableWords = WordsView.getSortUnmodifiableWords();
        for (Word word : unmodifiableWords) {
            Translate translate = word.getTranslations().get(0);
            put(data, word.getWord(), translate.getWordClass() + "*" + translate.getWordTranslations());
        }
        Status status = Status.OKAY;
        put(data, status.getKey(), status.getValue());
        return data;

    }


}
