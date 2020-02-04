package com.zhengjx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootConfiguration
//本服务启动后会自动注册进eureka服务
//@EnableEurekaClient
//@EnableDiscoveryClient
//@EnableAutoConfiguration
@SpringBootApplication
public class DeptProvider8001_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_App.class,args);
    }
}
