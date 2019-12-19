package com.stu.servicehei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @GetMapping(value = "/getAll")
    public String getAllStu(){
        return "我们都是好学生";
    }
}
