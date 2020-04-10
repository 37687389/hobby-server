package com.stu.admin.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


@Configuration
@EnableFeignClients
public class FeignRequestIntercepter implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        //通过RequestContextHolder获取本地请求
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }
        //获取本地线程绑定的请求对象
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        System.out.println("=session-id: "+request.getSession().getId());
        //给请求模板附加本地线程头部信息，主要是cookie信息
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                Enumeration<String> values = request.getHeaders(name);
                while (values.hasMoreElements()) {
                    String value = values.nextElement();
                    template.header(name, value);
                    System.out.println("name= "+name+"  value= "+value);
                }
            }
        }
    }

}
