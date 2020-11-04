package com.hy.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
//针对具体的服务
@RibbonClient(name = "eureka-client",configuration = com.netflix.loadbalancer.RandomRule.class)
public class RibbonConfig {

    /**
     * 更改ribbon负载均衡规则 全局
     * @return
     */
//    @Bean
//    public IRule defaultLBStrategy(){
//        return new RandomRule();
//    }
}
