package com.iotek.biz.impl;

import com.iotek.biz.SalaryService;
import com.iotek.dao.SalaryMapper;
import com.iotek.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
@Service
public class SalaryServiceImpl implements SalaryService {
   @Autowired
   private SalaryMapper salaryMapper;
    @Override
    public int deleteByID(Salary salary) {
        return salaryMapper.deleteByID(salary);
    }

    @Override
    public int addSalary(Salary salary) {
        return salaryMapper.addSalary(salary);
    }

    @Override
    public Salary selectByID(Salary salary) {
        return salaryMapper.selectByID(salary);
    }

    @Override
    public List<Salary> selectAllSalary() {
        return salaryMapper.selectAllSalary();
    }

    @Override
    public int updateByID(Salary salary) {
        return salaryMapper.updateByID(salary);
    }

    @Override
    public List<Salary> selectByEiD(Salary salary) {
        return salaryMapper.selectByEiD(salary);
    }
}
