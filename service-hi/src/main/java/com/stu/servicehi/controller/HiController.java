package com.stu.servicehi.controller;

import com.stu.servicehi.feign.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hidemo")
public class HiController {
    @Autowired
    private FeignService feignService;
    @GetMapping(value = "/getAll")
    public String getStu(){
        return this.feignService.getAllStudent();
    }
}
