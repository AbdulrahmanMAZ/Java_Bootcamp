package com.example.homework12.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/name")
    public String getName(){
        return "My name is: Abdulrahman";
    }
    @GetMapping("/age")
    public String getAge(){
        return "My name is: Abdulrahman";
    }
    @GetMapping("/check/status")
    public String checkStatus(){
        return "Everything OK";
    }
    @GetMapping("/health")
    public String checkHealth(){
        return "Server health is up and running";
    }
}
