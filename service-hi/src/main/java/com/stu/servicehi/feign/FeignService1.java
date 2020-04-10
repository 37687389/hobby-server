package com.stu.servicehi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gateway-server1")//通注册中心调用
//@FeignClient(value = "github", url = "${github.url}")//三方调用
public interface FeignService1 {
    @GetMapping(value = "/service-demo2/getName")
    String getName();
}
