package com.decmoon.decluna.controller;

import com.alibaba.fastjson.JSONObject;
import com.decmoon.decluna.service.elf.ElfService;
import com.decmoon.decluna.storage.elf.LunaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.Callable;

/**
 * Luna elf function controller
 *
 * @author decmoon
 */
@Controller
@RequestMapping("/elf")
public class LunaElfController {

    @Autowired
    private ElfService elfService;


    @RequestMapping("/getLunaTalk")
    @ResponseBody
    public Callable<JSONObject> lunaTalk() {
        return () -> LunaConfig.LUNA_TALK;
    }

    @RequestMapping("/change")
    @ResponseBody
    public Callable<JSONObject> changeModel(String lunaCode) {
        return () -> elfService.changeModel(lunaCode);
    }


    @RequestMapping("/model")
    @ResponseBody
    public Callable<JSONObject> model(String lunaCode) {
        return () -> elfService.model(lunaCode);
    }


    @RequestMapping("/down")
    public void downloadFile(HttpServletResponse response, String path) throws Exception {
        elfService.fileDownload(response, path);
    }


}
