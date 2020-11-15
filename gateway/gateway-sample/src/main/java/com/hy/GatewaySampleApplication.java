package com.hy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: $- GatewauySampleApplication -$ #-->
 * @Author: 寒夜
 * @CreateDate: 2020/11/15 14:47
 * @UpdateUser: 寒夜
 * @UpdateDate: 2020/11/15 14:47
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewaySampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewaySampleApplication.class,args);

    }
}
