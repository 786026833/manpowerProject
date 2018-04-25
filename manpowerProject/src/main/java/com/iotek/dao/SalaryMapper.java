package com.iotek.dao;

import com.iotek.model.Salary;

import java.util.List;

public interface SalaryMapper {
    int deleteByID(Salary salary);
    int addSalary(Salary salary);
    Salary selectByID(Salary salary);
    List<Salary> selectAllSalary();
    int updateByID(Salary salary);
}