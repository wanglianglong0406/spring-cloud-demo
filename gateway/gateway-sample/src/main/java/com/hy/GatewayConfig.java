package com.hy;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;

/**
 * @Description: $- GatewayConfig -$ #-->
 * @Author: 寒夜
 * @CreateDate: 2020/11/15 15:27
 * @UpdateUser: 寒夜
 * @UpdateDate: 2020/11/15 15:27
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Configuration
public class GatewayConfig {
    @Bean
    @Order
    public RouteLocator customizedRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/java/**")
                        .and().method(HttpMethod.GET)
                        .and().header("name")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://FEIGN-CLIENT")
                ).build();
    }
}
