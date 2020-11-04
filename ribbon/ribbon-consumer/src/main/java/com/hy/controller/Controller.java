package com.hy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class Controller {

    @Resource
    RestTemplate restTemplate;
    @GetMapping("/say-hi")
    public String sayHi(){
        return restTemplate.getForObject("http://eureka-client/say-hi",String.class);
    }
}
