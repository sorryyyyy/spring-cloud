package com.zhengjx.springcloud.controller;

import com.zhengjx.springcloud.entities.DeptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    private static  final String REST_URL_FREFIX = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(DeptEntity dept){
        return restTemplate.postForObject(REST_URL_FREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/findById/{deptNo}")
    public DeptEntity findById(@PathVariable("deptNo") Long deptNo){
        return restTemplate.getForObject(REST_URL_FREFIX+"/dept/findById"+deptNo,DeptEntity.class);
    }


    @RequestMapping(value = "/consumer/dept/findAll")
    public List<DeptEntity> findAll(){
        return restTemplate.getForObject(REST_URL_FREFIX+"/dept/findAll",List.class);
    }
}
