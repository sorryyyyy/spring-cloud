package com.zhengjx.springcloud.service;

import com.zhengjx.springcloud.entities.DeptEntity;

import java.util.List;


/**
 *     dept service接口
 * @author  com.zhengjx
 * @date 2020/2/3 15:20
 */
public interface DeptService {

    /**
     * 插入
     * @param deptEntity
     * @return
     */
    boolean addDept(DeptEntity deptEntity);

    /**
     * 根据id查找
     * @param deptNo
     * @return
     */
    DeptEntity findById(Long deptNo);

    /**
     * 查询全部
     * @return
     */
    List<DeptEntity> findAll();

    /**
     * 根据部门id更新部门名称
     * @param deptNo
     */
    boolean updateByDeptNo(String deptName,Long deptNo);

}
