package com.hy.config;

import com.hy.rules.MyRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
//针对具体的服务
//@RibbonClient(name = "eureka-client",configuration = com.netflix.loadbalancer.RandomRule.class)

@RibbonClient(name = "eureka-client",configuration = MyRule.class)
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
