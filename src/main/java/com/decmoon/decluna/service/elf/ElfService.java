package com.decmoon.decluna.service.elf;

import com.alibaba.fastjson.JSONObject;
import com.decmoon.decluna.storage.elf.LunaCode;
import com.decmoon.decluna.storage.elf.LunaConfig;
import com.decmoon.decluna.storage.elf.LunaMessage;
import com.decmoon.decluna.storage.utils.Jsons;
import com.decmoon.shortcut.argument.Arguments;
import com.decmoon.shortcut.collection.list.Lists;
import com.decmoon.shortcut.exception.ExceptionLogger;
import com.decmoon.shortcut.math.RandomNumberGenerator;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

import static com.decmoon.decluna.storage.utils.Jsons.getJsonFromFile;
import static com.decmoon.decluna.storage.utils.Jsons.newJSONObject;
import static com.decmoon.decluna.storage.utils.Jsons.put;

/**
 * @author decmoon
 */
@Service
public class ElfService {

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
            return getJsonFromFile(LunaConfig.PATH + lunaCode);
        else
            ExceptionLogger.parameterErr(ElfService.class, "model(String lunaCodeString)", "lunaCode not exist");
        return null;
    }

    /**
     * The Sprite file needs to be retrieved from a resource
     *
     * @param response
     * @param path
     * @throws IOException
     */
    public void fileDownload(HttpServletResponse response, String path) throws IOException {
        File file = new File(Jsons.class.getResource(path).getPath());
        if (file.exists()) {
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes("utf-8"), "ISO-8859-1"));
            byte[] buffer = new byte[1024];
            FileInputStream fis;
            BufferedInputStream bis;
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        }
    }


}
