package com.iotek.dao;

import com.iotek.model.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteById(Department department);
    int addDepartment(Department department);
    List<Department> selectAllDepartment();
    int updateById(Department department);
    Department selectById(Department department);
}