package com.hy;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 寒夜
 */
@SpringBootApplication
@EnableDiscoveryClient
public class FeginClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(FeginClientApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
