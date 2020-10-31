package com.hy.controller;

import com.hy.entity.Friend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controller {
    @Value("${server.port}")
    private String port;

    @GetMapping("/say-hi")
    public String sayHi(){
        return "this is "+ port;
    }

    @PostMapping("/say-hi")
    public Friend sayHiPost(@RequestBody Friend friend){

        friend.setPort(port);
        log.info("You are "+friend.getName()+friend.getPort());
        return friend;
    }
}
