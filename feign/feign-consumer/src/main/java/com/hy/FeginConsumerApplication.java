package com.hy;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeginConsumerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FeginConsumerApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
