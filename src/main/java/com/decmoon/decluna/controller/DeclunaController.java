package com.decmoon.decluna.controller;

import com.alibaba.fastjson.JSONObject;
import com.decmoon.decluna.service.page.CheckService;
import com.decmoon.decluna.service.page.LookupService;
import com.decmoon.decluna.service.page.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

/**
 * Main function controller
 *
 * @author decmoon
 */
@Controller
@RequestMapping("/word")
public class DeclunaController {
    @Autowired
    private RecordService recordService;
    @Autowired
    private CheckService checkService;
    @Autowired
    private LookupService lookupService;

    @PostMapping("/record/add")
    @ResponseBody
    public Callable<JSONObject> add(String wordName, String translate) {
        return () -> recordService.add(wordName.trim(), translate);
    }

    @GetMapping("/check/check")
    @ResponseBody
    public Callable<JSONObject> check() {
        return () -> checkService.check();
    }

    @PostMapping("/lookup/search")
    @ResponseBody
    public Callable<JSONObject> lookup(String wordName) {
        return () -> lookupService.lookup(wordName.trim());
    }

}
