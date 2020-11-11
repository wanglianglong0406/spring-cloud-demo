package com.hy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 寒夜
 */
@RestController
@Slf4j
public class Controller implements IService {
    @Value("${server.port}")
    private String port;
    @Override
    public String sayHi() {
        return "this is "+ port;
    }

    @Override
    public Friend sayHiPost(Friend friend) {
        friend.setPort(port);
        log.info("You are "+friend.getName()+friend.getPort());
        return friend;
    }

    @Override
    public String retry(@RequestParam("timeout") int timeout) {
        while (-- timeout >= 0 ){
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("retry "+port);
        return port;
    }

    @Override
    public String error() {
        throw new RuntimeException("black sheep");
    }
}
