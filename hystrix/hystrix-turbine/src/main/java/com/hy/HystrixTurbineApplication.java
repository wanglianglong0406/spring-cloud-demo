package com.hy;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Description: $- Hystrix?TurbineApplication -$ #-->
 * @Author: 寒夜
 * @CreateDate: 2020/11/9 9:52
 * @UpdateUser: 寒夜
 * @UpdateDate: 2020/11/9 9:52
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@EnableDiscoveryClient
@EnableHystrix
@EnableTurbine
@EnableCircuitBreaker
@EnableAutoConfiguration
public class HystrixTurbineApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixTurbineApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
