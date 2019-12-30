package com.hp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName LyApiGateway
 * @Description Zuul网关启动类
 * @Author Ankhci
 * @Date 2019/12/30 16:33
 **/
@SpringBootApplication
@EnableDiscoveryClient//开启Eureka客户端
@EnableZuulProxy
public class LyApiGateway {
    public static void main(String[] args) {
        SpringApplication.run(LyApiGateway.class,args);
    }
}
