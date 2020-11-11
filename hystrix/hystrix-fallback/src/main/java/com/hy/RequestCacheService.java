package com.hy;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: $RequestCacheService
 * @Author: 寒夜
 * @CreateDate: 2020/11/8 18:35
 * @UpdateUser: 寒夜
 * @UpdateDate: 2020/11/8 18:35
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Slf4j
@Service
public class RequestCacheService {
    @Autowired
    private MyService myService;

    @CacheResult
    @HystrixCommand(commandKey = "cacheKey")
    public Friend requestCache(@CacheKey String name) {
        log.info("request cache " + name);
        Friend friend = new Friend();
        friend.setName(name);
        friend = myService.sayHiPost(friend);
        log.info("after requesting cache" + name);
        return friend;

    }

}
