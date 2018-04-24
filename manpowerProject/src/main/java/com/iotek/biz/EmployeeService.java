package com.iotek.biz;

import com.iotek.model.Employee;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
public interface EmployeeService {
    int deleteByID(Employee employee);
    int addEmployee(Employee employee);
    List<Employee> selectAllEmployee();
    int updateByID(Employee employee);
    int updateByID1(Employee employee);
}
