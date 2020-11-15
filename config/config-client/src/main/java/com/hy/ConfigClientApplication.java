package com.hy;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: $- ConfigClientApplication -$ #-->
 * @Author: 寒夜
 * @CreateDate: 2020/11/12 15:53
 * @UpdateUser: 寒夜
 * @UpdateDate: 2020/11/12 15:53
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigClientApplication.class).web(WebApplicationType.SERVLET).run(args);

    }
}
