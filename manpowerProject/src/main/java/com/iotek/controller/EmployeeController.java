package com.iotek.controller;

import com.iotek.biz.EmployeeService;
import com.iotek.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Administrator on 2018/4/24.
 */@Controller
public class EmployeeController {
     @Autowired
    private EmployeeService employeeService;
     @RequestMapping("/addEmployee")
    public String addEmployee(Employee employee, HttpServletRequest request, HttpSession session){
         employee.seteJoinDate(new Date());
         employee.seteTrain((long)0);
         employeeService.addEmployee(employee);
         session.setAttribute("error4","员工录入成功");
         return "resumeDd";
     }
}
