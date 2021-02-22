package com.adarsh.SpringBoot.controller;

import org.springframework.context.event.SourceFilteringListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping(path="/hello")
    public String helloWorld(){
        return "HelloWorld";
    }
}
