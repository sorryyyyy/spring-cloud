package com.zhengjx.springcloud.controller;

import com.zhengjx.springcloud.entities.DeptEntity;
import com.zhengjx.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *     消费者调用控制器
 * @author  zhengjx
 * @date 2020/2/3 13:27
 */
@RestController
public class DeptController_Consumer {

    @Autowired
    //Feign面向接口编程
    private DeptClientService deptClientService;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(DeptEntity deptEntity){
        //三个参数：url,requestMap ResponseBean.class
        return  deptClientService.add(deptEntity);
    }
    @RequestMapping("/consumer/dept/findById/{deptNo}")
    public DeptEntity findById(@PathVariable("deptNo") Long deptNo){
        //三个参数：url,requestMap ResponseBean.class
        return deptClientService.findById(deptNo);
    }
    @RequestMapping(value = "/consumer/dept/findAll")
    public List findAll(){
        //三个参数：url,requestMap ResponseBean.class
        return  deptClientService.findAll();
    }

}
