package com.hy.controller;

import com.hy.entity.Friend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 寒夜
 */
@RestController
@Slf4j
public class Controller {

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello(){
        ServiceInstance instance =loadBalancerClient.choose("eureka-client");

        if(instance ==null){
            return "Not available instance ";
        }
        String target = String.format("http://%s:%s/say-hi",instance.getHost(),instance.getPort());

        log.info("url is {} ",target);

        return restTemplate.getForObject(target,String.class);
    }
    @PostMapping("/hello")
    public Friend helloPost(){
        ServiceInstance instance =loadBalancerClient.choose("eureka-client");

        if(instance ==null){
            return null;
        }
        String target = String.format("http://%s:%s/say-hi",instance.getHost(),instance.getPort());

        log.info("url is {} ",target);
        Friend friend=new Friend();
        friend.setName("Eureka consumer...");

        return  restTemplate.postForObject(target,friend,Friend.class);
    }

}
