package com.hp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName LyRegistry
 * @Description Eureka启动类
 * @Author Ankhci
 * @Date 2019/12/30 16:23
 **/
@SpringBootApplication
@EnableEurekaServer //开启Eureka服务
public class LyRegistry {
    public static void main(String[] args) {
        SpringApplication.run(LyRegistry.class,args);
    }
}
