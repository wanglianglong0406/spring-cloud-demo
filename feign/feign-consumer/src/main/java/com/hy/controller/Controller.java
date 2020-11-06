package com.hy.controller;

import com.hy.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private IService iService;

    @GetMapping("say-hi")
    public String sayHi(){
        return iService.sayHi();
    }
}
