package com.hy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("feign-client")
public interface IService {
    @GetMapping("/say-hi")
    public String sayHi();

    @PostMapping("/say-hi")
    public Friend sayHiPost(@RequestBody Friend friend);

    @GetMapping("/retry")
    public String retry(@RequestParam("timeout") int timeout);

    @GetMapping("error")
    public String error();
}
