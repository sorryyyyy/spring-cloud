package com.zhengjx.springcloud.dao;

import com.zhengjx.springcloud.entities.DeptEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *     部门dao接口
 * @author  com.zhengjx
 * @date 2020/2/3 13:37
 */
@Mapper
public interface DeptDao {

    /**
     * 插入
     * @param deptEntity 部门实例
     * @return
     */
    boolean addDept(DeptEntity deptEntity);

    /**
     * 根据id查找
     * @param deptNo 部门编码
     * @return 返回部门数据
     */
    DeptEntity findById(Long deptNo);

    /**
     * 查询全部
     * @return 部门数据list
     */
    List<DeptEntity> findAll();

}
