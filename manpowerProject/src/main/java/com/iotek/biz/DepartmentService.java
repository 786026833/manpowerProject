package com.iotek.biz;

import com.iotek.model.Department;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
public interface DepartmentService {
    int deleteById(Department department);
    int addDepartment(Department department);
    List<Department> selectAllDepartment();
    List<Department> selectAllDep_pos_empl();
    int updateById(Department department);
}
