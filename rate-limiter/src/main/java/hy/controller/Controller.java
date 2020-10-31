package hy.controller;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author 寒夜
 */
@RestController
@Slf4j
public class Controller {
    RateLimiter limiter = RateLimiter.create(2.0);

    /**
     * 非阻塞限流
     *
     * @param count 令牌个数
     * @return success/fail
     */
    @GetMapping("/tryAcquire")
    public String tryAcquire(Integer count) {
        if (limiter.tryAcquire(count)) {
            log.info("success,rate is {}", limiter.getRate());
            return "success";
        } else {
            log.info("fail ,rate is {} ", limiter.getRate());
            return "fail";
        }

    }

    /**
     * 限定时间的非阻塞限流
     *
     * @param count 令牌个数
     * @return success/fail
     */
    @GetMapping("/tryAcquireWithTimeOut")
    public String tryAcquireWithTimeOut(Integer count, Integer timeout) {
        if (limiter.tryAcquire(count, timeout, TimeUnit.SECONDS)) {
            log.info("success,rate is {}", limiter.getRate());
            return "success";
        } else {
            log.info("fail ,rate is {} ", limiter.getRate());
            return "fail";
        }

    }

    /**
     * 同步阻塞限流
     * @param count 令牌个数
     * @return success
     */
    @GetMapping("/acquire")
    public String acquire(Integer count) {
        limiter.acquire(count);
        log.info("success,rate is {}", limiter.getRate());
        return "success";
    }


    @GetMapping("/nginx")
    public String nginx(){
        log.info("Nginx success");
        return "success";
    };

}
