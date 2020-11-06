package com.hy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 寒夜
 */
@RestController
public class Controller {
    @Autowired
    private IService iService;

    @GetMapping("say-hi")
    public String sayHi(){
        return iService.sayHi();
    }

    @PostMapping("say-hi")
    public Friend sayHi2(){
        Friend friend=new Friend();
        friend.setName("我是陌上千寻雪");
        return iService.sayHiPost(friend);
    }

    @GetMapping("retry")
    public String retry(int timeout){
        return iService.retry(timeout);
    }
}
