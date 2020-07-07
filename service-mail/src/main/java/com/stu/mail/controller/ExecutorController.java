package com.stu.mail.controller;

import com.stu.mail.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExecutorController {
    private static final Logger logger = LoggerFactory.getLogger(ExecutorController.class);
    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/ececutor")
    public String submit() {

        logger.info("start submit");
        //调用service层的任务
        asyncService.executeAsync();
        logger.info("end submit");
        return "success";

    }
}
