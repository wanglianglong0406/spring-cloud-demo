package com.hy;

import com.hy.annotation.AccessLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 寒夜
 */
@RestController
@Slf4j
public class Controller {

    private final com.hy.AccessLimiter accessLimiter;

    public Controller(com.hy.AccessLimiter accessLimiter) {
        this.accessLimiter = accessLimiter;
    }

    @GetMapping("test")
    public String test() {
        accessLimiter.limitAccess("ratelimiter-test", 3);
        return "success";
    }

    // 提醒！ 注意配置扫包路径（com.hy路径不同）
    @GetMapping("test-annotation")
    @AccessLimiter(limit = 1)
    public String testAnnotation() {
        return "success";
    }

}
