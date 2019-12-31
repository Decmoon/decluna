package com.decmoon.decluna.service.elf;

import com.alibaba.fastjson.JSONObject;
import com.decmoon.decluna.storage.core.Words;
import com.decmoon.decluna.storage.elf.LunaCode;
import com.decmoon.decluna.storage.elf.LunaConfig;
import com.decmoon.decluna.storage.elf.LunaMessage;
import com.decmoon.decluna.storage.io.ResponseDownload;
import com.decmoon.decluna.storage.io.WordsMemory;
import com.decmoon.shortcut.argument.Arguments;
import com.decmoon.shortcut.collection.list.Lists;
import com.decmoon.shortcut.exception.ExceptionLogger;
import com.decmoon.shortcut.file.Files;
import com.decmoon.shortcut.math.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.decmoon.decluna.storage.utils.Jsons.*;

/**
 * @author decmoon
 */
@Service
public class ElfService {

    @Autowired
    private ResponseDownload responseDownload;


    /**
     * get model resource string
     *
     * @param lunaCode
     * @return
     */
    public JSONObject changeModel(String lunaCode) {
        List<String> lunaCodeList = Lists.newArrayList(LunaCode.getLunaCodeList());
        if (Arguments.parameterLegal(LunaCode.getLunaCode(lunaCode + ".luna"))) {
            lunaCodeList.remove(lunaCode);
            String newLunaCode = lunaCodeList.get(RandomNumberGenerator.random(0, lunaCodeList.size()));
            JSONObject jsonObject = newJSONObject();
            put(jsonObject, "lunaCode", newLunaCode.split("\\.")[0]);
            put(jsonObject, "message", LunaMessage.getMessage(newLunaCode));
            return jsonObject;
        } else {
            ExceptionLogger.parameterErr(ElfService.class, "changeModel(String lunaCode)", "lunaCode is not exist");
        }
        return null;

    }

    /**
     * get model resource
     *
     * @param lunaCodeString
     * @return
     */
    public JSONObject model(String lunaCodeString) {
        String lunaCode = LunaCode.getLunaCode(lunaCodeString + ".luna");
        if (Arguments.parameterLegal(lunaCode))
            return getJsonFromFile(LunaConfig.getPATH() + lunaCode);
        else
            ExceptionLogger.parameterErr(ElfService.class, "model(String lunaCodeString)", "lunaCode not exist");
        return null;
    }

    /**
     * The Sprite file needs to be retrieved from a resource
     *
     * @param response
     * @param path
     */
    public void fileDownload(HttpServletResponse response, String path) {
        File file = new File(ElfService.class.getResource(path).getPath());
        if (file.exists()) {
            responseDownload.download(response, file);
        }
    }

    public void export(HttpServletResponse response) {
        final String path = "/static/framework/decluna/config/words/word_memory.decluna";
        File file = new File(ElfService.class.getResource(path).getPath());
        if (file.exists()) {
            responseDownload.download(response, file);
        }
    }

    public void fileImport(MultipartFile multipartFile, HttpServletResponse response) {
        try {
            String originalFilename = multipartFile.getOriginalFilename();
            if (WordsMemory.getNAME().equals(originalFilename)) {
                File file = Files.newFile(WordsMemory.getPATH());
                multipartFile.transferTo(file);
                Words.fileImport();
                response.sendRedirect("/contents");
            } else {
                response.sendRedirect("/error");
            }
        } catch (IOException e) {
            ExceptionLogger.parameterErr(ElfService.class, "fileImport(MultipartFile multipartFile, HttpServletResponse response)", e);
        }

    }


}
