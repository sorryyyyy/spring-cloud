package com.zhengjx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *     eureka服务端主启动类
 * @author  com.zhengjx
 * @date 2020/2/5 12:11
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7003_app {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7003_app.class,args);
    }
}
