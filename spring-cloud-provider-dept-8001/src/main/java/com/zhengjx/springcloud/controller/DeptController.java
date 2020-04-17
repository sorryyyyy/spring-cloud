package com.zhengjx.springcloud.controller;


import com.zhengjx.springcloud.entities.DeptEntity;
import com.zhengjx.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *     dept控制器
 * @author  com.zhengjx
 * @date 2020/2/3 15:19
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean addDept(@RequestBody DeptEntity deptEntity) {
        return deptService.addDept(deptEntity);
    }

    @RequestMapping(value = "/dept/findById/{deptNo}",method = RequestMethod.GET)
    public DeptEntity findById(@PathVariable("deptNo") Long deptNo) {
        return deptService.findById(deptNo);
    }

    @RequestMapping(value = "/dept/findAll",method = RequestMethod.GET)
    public List<DeptEntity> findAll() {
        return deptService.findAll();
    }

    @RequestMapping(value = "/dept/updateByDeptNo/{deptNo}/{deptName}",method = RequestMethod.GET)
    public boolean updateByDeptNo(@PathVariable("deptNo") Long deptNo,@PathVariable("deptName") String deptName) {
        return deptService.updateByDeptNo(deptName,deptNo);
    }

    /**
     * 增加自己服务描述的接口
     * @return 输出服务描述
     */
    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        System.out.println("总共有多少个微服务"+list.size());

        //查询STUDY-SPRINGCLOUD-DEPT 服务
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-DEPT8001");

        //打印STUDY-SPRINGCLOUD-DEPT服务信息
        for (ServiceInstance element :instances){
            System.out.println(element.getServiceId());
            System.out.println(element.getHost());
            System.out.println(element.getPort());
            System.out.println(element.getUri());
        }
        return this.discoveryClient;

    }
}
