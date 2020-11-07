package com.hy.hystrix;

import com.hy.Friend;
import com.hy.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FallBack implements MyService {
    @Override
    public String sayHi() {
        return null;
    }

    @Override
    public Friend sayHiPost(Friend friend) {
        return null;
    }

    @Override
    public String retry(int timeout) {
        log.info("You ar late...");
        return "You are late...";
    }

    @Override
    public String error() {
        log.info("FullBack I`m not a black sheep any more...");
        return "FullBack I`m not a black sheep any more...";
    }
}
