package com.stu.demo.controller;

import com.stu.demo.feign.FeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private FeignService feignService;
    @GetMapping("getName")
    public String getName(){
        Map<String, String> headersInfo = getHeadersInfo();
         for(String s :headersInfo.keySet()){
             System.out.println("key: "+s+"value: "+headersInfo.get(s));
         }
        return "demo";
    }
    @GetMapping("getUserName")
    public String getUserName(){
        Map<String, String> headersInfo = getHeadersInfo();
        for(String s :headersInfo.keySet()){
            System.out.println("key: "+s+"value: "+headersInfo.get(s));
        }
        return feignService.getName();
    }
    private Map<String, String> getHeadersInfo() {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }
}
