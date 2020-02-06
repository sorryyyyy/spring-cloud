package com.zhengjx.springcloud.service.impl;

import com.zhengjx.springcloud.dao.DeptDao;
import com.zhengjx.springcloud.entities.DeptEntity;
import com.zhengjx.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *     dept Service实现类
 * @author  com.zhengjx
 * @date 2020/2/3 15:22
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(DeptEntity deptEntity) {
        return   deptDao.addDept(deptEntity);
    }

    @Override
    public DeptEntity findById(Long deptNo) {
        return  deptDao.findById(deptNo);
    }

    @Override
    public List<DeptEntity> findAll() {
        return deptDao.findAll();
    }
}
