package com.stu.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(value = "github", url = "${github.url}")//三方调用
@FeignClient(name = "service-main")//通注册中心调用
public interface FeignService {
    /**
     * 获取所有学生列表
     * @return
     */
    @GetMapping(value = "/admin/getName")
    String getName();
}
