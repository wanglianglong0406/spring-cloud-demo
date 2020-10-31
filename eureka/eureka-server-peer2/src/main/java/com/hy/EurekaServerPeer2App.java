package com.hy;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 寒夜
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerPeer2App {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaServerPeer2App.class).web(WebApplicationType.SERVLET).run(args);
    }
}
