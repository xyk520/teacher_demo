package com.ujiuye.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/sayHello")
    public String sayHello(){
        return "aaaaaaaaa";
    }
}
