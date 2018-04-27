package com.iotek.biz.impl;

import com.iotek.biz.DepartmentService;
import com.iotek.dao.DepartmentMapper;
import com.iotek.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
@Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public int deleteById(Department department) {
        return departmentMapper.deleteById(department);
    }

    @Override
    public int addDepartment(Department department) {
        return departmentMapper.addDepartment(department);
    }

    @Override
    public List<Department> selectAllDepartment() {
        return departmentMapper.selectAllDepartment();
    }

    @Override
    public List<Department> selectAllDep_pos_empl() {
        return departmentMapper.selectAllDep_pos_empl();
    }

    @Override
    public int updateById(Department department) {
        return departmentMapper.updateById(department);
    }
}
