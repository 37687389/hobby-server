package com.stu.mail.service.impl;

import com.stu.mail.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncServiceImpl implements AsyncService {
    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {

        logger.info("start executeAsync");

        try {

            Thread.sleep(3000);

        } catch (Exception e) {

            e.printStackTrace();

        }

        logger.info("end executeAsync:"+Thread.currentThread().getName());

    }

}
