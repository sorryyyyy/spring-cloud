package com.zhengjx.springcloud.controller;

import com.zhengjx.springcloud.entities.DeptEntity;
import com.zhengjx.springcloud.service.DeptService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeptControllerTest {
    @Autowired
    private DeptService deptService;


    @Test
    public List<DeptEntity> findAll() {
        System.out.println(deptService.findAll());
        return deptService.findAll();
    }

}
