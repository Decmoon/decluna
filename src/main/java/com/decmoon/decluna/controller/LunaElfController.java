package com.decmoon.decluna.controller;

import com.alibaba.fastjson.JSONObject;
import com.decmoon.decluna.service.elf.ElfService;
import com.decmoon.decluna.storage.elf.LunaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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


    @PostMapping("/getLunaTalk")
    @ResponseBody
    public Callable<JSONObject> lunaTalk() {
        return LunaConfig::getLUNA_TALK;
    }

    @GetMapping("/change")
    @ResponseBody
    public Callable<JSONObject> changeModel(String lunaCode) {
        return () -> elfService.changeModel(lunaCode);
    }


    @GetMapping("/model")
    @ResponseBody
    public Callable<JSONObject> model(String lunaCode) {
        return () -> elfService.model(lunaCode);
    }

    @GetMapping("/down")
    public void downloadFile(HttpServletResponse response, String path) {
        elfService.fileDownload(response, path);
    }


    @GetMapping("/export")
    public void export(HttpServletResponse response) {
        elfService.export(response);
    }


    @PostMapping("/import")
    public void fileImport(@RequestParam("fileImport") MultipartFile multipartFile, HttpServletResponse response) {
        elfService.fileImport(multipartFile, response);
    }


}
