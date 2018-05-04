package com.iotek.biz;

import com.iotek.model.Salary;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
public interface SalaryService {
    int deleteByID(Salary salary);
    int addSalary(Salary salary);
    Salary selectByID(Salary salary);
    List<Salary> selectAllSalary();
    int updateByID(Salary salary);
    List<Salary> selectByEiD(Salary salary);
}
