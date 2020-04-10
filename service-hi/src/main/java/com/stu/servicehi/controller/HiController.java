package com.stu.servicehi.controller;

import com.stu.servicehi.feign.FeignService;
import com.stu.servicehi.feign.FeignService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hidemo")
public class HiController {
    @Autowired
    private FeignService feignService;
    @Autowired
    private FeignService1 feignService1;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @GetMapping(value = "/getAll")
    public String getStu(){
        return this.feignService.getAllStudent();
    }
    @GetMapping(value = "/getName")
    public String getName(){
        String name = this.feignService.getName();
        System.out.println(name);
        return name;
    }
    @GetMapping(value = "/getName1")
    public String getName1(){
        String name = this.feignService1.getName();
        System.out.println(name);
        return name;
    }
    @GetMapping(value = "/setValue")
    public String setValue(){
        stringRedisTemplate.opsForValue().set("aa","vv");
        return stringRedisTemplate.opsForValue().get("aa");

    }
    @GetMapping("get")
    public Map<String,String> getSession(HttpServletRequest request){
        HashMap<String,String> map=new HashMap<String, String>();
        map.put("sessionId",request.getSession().getId());
        map.put("plange",request.getSession().getAttribute("plange").toString());
        map.put("local","本地的");
        return map;

    }

}
