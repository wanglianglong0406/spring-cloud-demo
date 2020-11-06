package com.hy.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 寒夜
 */
@FeignClient("eureka-client")
public interface IService {
    @GetMapping("say-hi")
    String sayHi();

}
