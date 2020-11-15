package com.hy;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Description: $- ConfigServerApplication -$ #-->
 * @Author: 寒夜
 * @CreateDate: 2020/11/12 15:13
 * @UpdateUser: 寒夜
 * @UpdateDate: 2020/11/12 15:13
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServerEurekaApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigServerEurekaApplication.class).web(WebApplicationType.SERVLET).run(args);

    }
    // 获取配置文件的不同URL姿势，都是GET请求
//    http://localhost:60000/{label}/{application}-{profile}.json
//    以上后缀可以换成.yml, .properties，如果不指定{label}的话默认用master
//
//    http://localhost:60000/{application}/{profile}/{label}
//    如果不指定{label}的话默认用master
}
