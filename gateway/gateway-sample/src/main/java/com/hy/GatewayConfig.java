package com.hy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;

import java.time.ZonedDateTime;

/**
 * @Description: $- GatewayConfig -$ #-->
 * @Author: 寒夜
 * @CreateDate: 2020/11/15 15:27
 * @UpdateUser: 寒夜
 * @UpdateDate: 2020/11/15 15:27n
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Configuration
public class GatewayConfig {
    @Autowired
    private TimerFilter timerFilter;
    @Bean
    @Order
    public RouteLocator customizedRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/java/**")
                        .and().method(HttpMethod.GET)
                        .and().header("name")
                        .filters(f -> f.stripPrefix(1)
                        //.filter(timerFilter)
                        )
                        .uri("lb://FEIGN-CLIENT")
                )
                .route(r -> r.path("/seckill/**")
                        .and().after(ZonedDateTime.now().plusMinutes(1))
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://FEIGN-CLIENT")
                )
                .build();
    }
}
