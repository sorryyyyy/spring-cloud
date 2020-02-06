package com.zhengjx.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *     自定义的Ribbon负载均衡算法类
 * @author  zhengjx
 * @date 2020/2/6 15:09
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        //指定LoadBalanced的算法 用我们自定义的规则算法
        return new MyRandomRule();
    }
}
