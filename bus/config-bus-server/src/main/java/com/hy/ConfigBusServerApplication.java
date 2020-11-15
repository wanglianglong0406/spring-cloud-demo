package com.hy;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Description: $- ConfigBusServerApplication -$ #-->
 * @Author: 寒夜
 * @CreateDate: 2020/11/15 9:01
 * @UpdateUser: 寒夜
 * @UpdateDate: 2020/11/15 9:01
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigBusServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigBusServerApplication.class).web(WebApplicationType.SERVLET).run(args);

    }
}
