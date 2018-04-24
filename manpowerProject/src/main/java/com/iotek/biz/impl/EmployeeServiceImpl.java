package com.iotek.biz.impl;

import com.iotek.biz.EmployeeService;
import com.iotek.dao.EmployeeMapper;
import com.iotek.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
@Service
public class EmployeeServiceImpl  implements EmployeeService {
@Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public int deleteByID(Employee employee) {
        return employeeMapper.deleteByID(employee);
    }

    @Override
    public int addEmployee(Employee employee) {
        return employeeMapper.addEmployee(employee);
    }

    @Override
    public List<Employee> selectAllEmployee() {
        return employeeMapper.selectAllEmployee();
    }

    @Override
    public int updateByID(Employee employee) {
        return employeeMapper.updateByID(employee);
    }

    @Override
    public int updateByID1(Employee employee) {
        return employeeMapper.updateByID1(employee);
    }
}
