package com.hy;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: $- ConfigBusClientApplication -$ #-->
 * @Author: 寒夜
 * @CreateDate: 2020/11/15 9:21
 * @UpdateUser: 寒夜
 * @UpdateDate: 2020/11/15 9:21
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigBusClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigBusClientApplication.class).web(WebApplicationType.SERVLET).run(args);

    }
}
