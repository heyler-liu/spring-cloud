package com.example.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "clientFallback")      //若客户端崩溃执行clientFallback
    public String client() {
        return restTemplate
                .getForEntity("http://EUREKA-CLIENT/", String.class).getBody();
    }

    public String clientFallback() {        //若客户端崩溃跳转至error
        return "error";
    }
}