package com.horsesf.bootlanuch.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping
    public String hello(String name){
        return "hello world---" + name;
    }
}
