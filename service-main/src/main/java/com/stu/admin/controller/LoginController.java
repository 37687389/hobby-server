package com.stu.admin.controller;

import com.stu.admin.feign.FeignService;
import com.stu.common.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/user")
public class LoginController {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private FeignService feignService;
    @PostMapping("/login")
    public ResponseData login(HttpServletRequest request, @RequestBody Map<String,String> map) {
        if (map.get("account") != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUserId", map.get("account"));
            redisTemplate.opsForValue().set("loginUser:" + map.get("account"), session.getId());

            return ResponseData.success("登录成功");
        } else {
            return ResponseData.error("请输入账号");
        }
    }
    @GetMapping("/getUserInfo")
    public ResponseData getUserInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object loginUserId = session.getAttribute("loginUserId");
        ResponseData res = ResponseData.success("登录成功", loginUserId);
        System.out.println(res);
        feignService.getUserInfo();
        return ResponseData.success("登录成功",loginUserId);
    }


}
