package com.iotek.dao;

import com.iotek.model.Employee;

import java.util.List;

public interface EmployeeMapper {
    int deleteByID(Employee employee);
    int addEmployee(Employee employee);
    List<Employee> selectAllEmployee();
    int updateByID(Employee employee);
    int updateByID1(Employee employee);
    Employee selectByNamePass(Employee employee);
    Employee selectById(Employee employee);
}