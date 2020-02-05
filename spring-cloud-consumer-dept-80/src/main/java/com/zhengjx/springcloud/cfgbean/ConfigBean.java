package com.zhengjx.springcloud.cfgbean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *     消费者config配置类
 * @author  com.zhengjx
 * @date 2020/2/4 13:11
 */
@Configuration
public class ConfigBean {

    @Bean
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
