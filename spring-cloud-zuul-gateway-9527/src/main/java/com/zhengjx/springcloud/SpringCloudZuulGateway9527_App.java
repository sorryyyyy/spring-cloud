package com.zhengjx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *     zuul路由控制启动类
 * @author  zhengjx
 * @date 2020/2/8 14:05
 */
@SpringBootApplication
@EnableZuulProxy
public class SpringCloudZuulGateway9527_App {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulGateway9527_App.class,args);
    }
}
