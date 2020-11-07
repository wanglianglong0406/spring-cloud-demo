package com.hy;

import com.hy.hystrix.FallBack;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "feign-client", fallback = FallBack.class)
public interface MyService extends IService {
}
