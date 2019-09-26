package com.example.fegin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("EUREKA-CLIENT")
//FeignClient是指被feign代理的几个负载均衡服务
//EUREKA-CLIENT是被负载均衡的模块在Eureka中的名称
public interface FeignService {
    @RequestMapping("/")            //当代理了EUREKA-CLIENT之后，要调用的是这个EUREKA-CLIENT里面控制器的超链接
    String hello();
}