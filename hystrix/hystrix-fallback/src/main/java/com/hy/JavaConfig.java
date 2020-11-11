package com.hy;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: $- JavaConfig -$ #-->
 * @Author: 寒夜
 * @CreateDate: 2020/11/9 11:06
 * @UpdateUser: 寒夜
 * @UpdateDate: 2020/11/9 11:06
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Configuration
public class JavaConfig {

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");//访问路径
        registrationBean.setName("hystrix.stream");
        return registrationBean;
    }

}
