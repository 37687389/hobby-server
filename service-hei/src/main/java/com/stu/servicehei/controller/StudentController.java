package com.stu.servicehei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @GetMapping(value = "/getAll")
    public String getAllStu(){
        return "我们都是好学生";
    }
    @GetMapping("get")
    public Map<String,String> getSession(HttpServletRequest request){
        HashMap<String,String> map=new HashMap<String, String>();
        map.put("sessionId",request.getSession().getId());
        map.put("local","hei的");
        map.put("pLange",request.getSession().getAttribute("plange").toString());
        return map;
    }
    @GetMapping("setLange")
    public Map<String,String> setLange(HttpServletRequest request){
        String pLange = request.getParameter("pLange");
        System.out.println(pLange);
        HttpSession session = request.getSession(true);
        session.setAttribute("plange",pLange);
        HashMap<String,String> map=new HashMap<String, String>();
        return map;
    }
}
