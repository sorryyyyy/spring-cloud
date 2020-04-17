package com.zhengjx.springcloud.cfgbean;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    //Spring Cloud Ribbon是基于Netflix Ribbon 实现的一套客户端  负载均衡的工具。
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
    @Bean
    public IRule myRule(){

        // 返回即是当前采用的负载均衡算法
      return new RoundRobinRule();
    }
}
