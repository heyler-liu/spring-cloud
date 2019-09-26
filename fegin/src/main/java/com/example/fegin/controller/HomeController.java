package com.example.fegin.controller;

import com.example.fegin.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private FeignService feignService;

    @RequestMapping("/client")
    public String helloFeign() {
        return feignService.hello();
    }
}