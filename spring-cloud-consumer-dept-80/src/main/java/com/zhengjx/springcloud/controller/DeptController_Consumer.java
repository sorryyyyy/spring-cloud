package com.zhengjx.springcloud.controller;

import com.zhengjx.springcloud.entities.DeptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
/**
 *     消费者调用控制器
 * @author  zhengjx
 * @date 2020/2/3 13:27
 */
@RestController
public class DeptController_Consumer {

    // 写死的主机及端口地址
    //private static  final String REST_URL_FREFIX = "http://localhost:8001";
    // 使用Eureka中的服务注册的应用名来用访问地址名称
    private static  final String REST_URL_FREFIX = "http://SPRINGCLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(DeptEntity dept){
        return restTemplate.postForObject(REST_URL_FREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/findById/{deptNo}")
    public DeptEntity findById(@PathVariable("deptNo") Long deptNo){
        return restTemplate.getForObject(REST_URL_FREFIX+"/dept/findById/"+deptNo,DeptEntity.class);
    }


    @RequestMapping(value = "/consumer/dept/findAll")
    public List<DeptEntity> findAll(){
        return restTemplate.getForObject(REST_URL_FREFIX+"/dept/findAll",List.class);
    }

    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        return  restTemplate.getForObject(REST_URL_FREFIX+"/dept/discovery", Object.class);
    }

}
