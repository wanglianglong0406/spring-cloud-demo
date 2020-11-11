package com.hy;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Description: $- HystrixDashBoardApplication -$ #-->
 * @Author: 寒夜
 * @CreateDate: 2020/11/9 10:33
 * @UpdateUser: 寒夜
 * @UpdateDate: 2020/11/9 10:33
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@SpringCloudApplication
@EnableHystrixDashboard
public class HystrixDashBoardApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixDashBoardApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
