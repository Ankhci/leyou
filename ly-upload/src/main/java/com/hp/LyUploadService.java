package com.hp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName LyUploadService
 * @Description 启动类
 * @Author Ankhci
 * @Date 2020/1/3 23:19
 **/
@SpringBootApplication
@EnableDiscoveryClient //Eureka客户端
public class LyUploadService {
    public static void main(String[] args) {
        SpringApplication.run(LyUploadService.class,args);
    }
}
