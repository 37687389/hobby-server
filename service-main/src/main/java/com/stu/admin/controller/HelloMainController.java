package com.stu.admin.controller;

import com.stu.common.ResponseData;
import com.stu.admin.feign.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class HelloMainController {
    @Autowired
    private FeignService feignService;
    @Autowired
    private HttpServletRequest request;
    @PostMapping("/createdFormData")
    public ResponseData createdFormData(@RequestBody Map<String,String> map){
        for (String s : map.keySet() ){
            System.out.println(s);
        }
        String name = feignService.getName();
        return ResponseData.success(name);
    }
    @PostMapping("/delFormData")
    public Map<String,String> delFormData(@RequestBody Map<String,String> map){
        for (String s : map.keySet() ){
            System.out.println(s);
        }
        //feignService.getName();
        return map;
    }
    @PostMapping("/updFormData")
    public Map<String,String> updFormData(@RequestBody Map<String,String> map){
        for (String s : map.keySet() ){
            System.out.println(s);
        }
        feignService.getName();
        return map;
    }
    @GetMapping("getName")
    public String getName(){
        Map<String, String> headersInfo = getHeadersInfo();
        for(String s :headersInfo.keySet()){
            System.out.println("key: "+s+"value: "+headersInfo.get(s));
        }
        return "UserName";
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
