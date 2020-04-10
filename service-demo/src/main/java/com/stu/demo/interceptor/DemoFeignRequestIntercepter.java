package com.stu.demo.interceptor;

import com.stu.interceptor.FeignRequestIntercepter;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
public class DemoFeignRequestIntercepter extends FeignRequestIntercepter {


}
