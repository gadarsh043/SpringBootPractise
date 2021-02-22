package com.adarsh.SpringBoot.controller;

import com.adarsh.SpringBoot.dto.MyControllerDTO2;
import com.adarsh.SpringBoot.dto.MyControllerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @GetMapping(path="/hello")
    public String helloWorld(){
        return "HelloWorld";
    }
    @PostMapping(path= "/hello-post")
    public String helloWorldPost()
    {
        return "Success-Again";
    }
    @GetMapping(path = "/hello-query")
    public String helloQuery(@RequestParam String query)
    {
        return "Hello\t"+query;
    }
    @PostMapping(value= "/register-yourself")
    public String registerUser(@RequestBody MyControllerDTO request)
    {
        return request.toString();
    }
    @GetMapping(path= "/register-id/{id}")
    public MyControllerDTO2 getEmployeeDetails(@PathVariable String id)
    {
        MyControllerDTO2 response=new MyControllerDTO2();
        response.setId(id);
        return response;
    }
}
