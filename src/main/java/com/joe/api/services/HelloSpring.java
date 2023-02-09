package com.joe.api.services;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloSpring {

    @RequestMapping(value = "/{id}")
    public String hello(@PathVariable int id){
        return "Hello World " + id;
    }
}
