package com.sjy.eval.oss.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: online-eval-clould
 * @description:
 * @author: Created by youxun
 * @create: 2018-12-26 09:56
 **/
@RestController
@RequestMapping("/user")
public class ArticleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);



    @GetMapping("index")
    public String index() {
        LOGGER.debug("debug测试debug");
        LOGGER.info("info测试info");
        LOGGER.warn("warn测试为人类历史");
        LOGGER.error("error奥术大师");
        return "hello world";
    }



}
