package com.iotek.controller;

import com.iotek.biz.DepartmentService;
import com.iotek.biz.EmployeeService;
import com.iotek.biz.PositionService;
import com.iotek.model.Department;
import com.iotek.model.Employee;
import com.iotek.model.Position;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */@Controller
public class EmployeeController {
     @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private DepartmentService departmentService;
     @RequestMapping("/addEmployee")
    public String addEmployee(Employee employee, HttpServletRequest request, HttpSession session){
         employee.seteJoinDate(new Date());
         employee.seteTrain((long)0);
         employeeService.addEmployee(employee);
         session.setAttribute("error4","员工录入成功");
         return "resumeDd";
     }
    @RequestMapping("/selectEmployee")
    public String selectEmployee(Model model,HttpSession session){
        List<Department> lists=departmentService.selectAllDepartment();
        session.setAttribute("allDepartments",lists);
        session.setAttribute("allPositions",positionService.selectAllPosition());
        session.setAttribute("allEmployees",employeeService.selectAllEmployee());
        return "selectEmployee";
    }
    @RequestMapping("/updateEmployee")
    public String updateEmployee(int pow, Employee employee, Model model, HttpServletRequest request, HttpSession session){
       if (pow==1){
           employeeService.updateByID(employee);
           model.addAttribute("update","调岗成功");
       }else if(pow==2){
           Date date1= new Date();
           long num=(date1.getTime()-employee.geteJoinDate().getTime())/(1000*60*60*24);
            if (num>90){//试用期三个月
                employee.seteState("正式员工");
                model.addAttribute("update","转正成功");
                employeeService.updateByID(employee);
            }else{
                model.addAttribute("update","未过试用期，不能转正");
            }
       }else{
           employee.seteDid((long)0);
           employee.setePid((long)0);
           employeeService.updateByID(employee);
           model.addAttribute("update","离职完成");
           /*离职后部门和职位为0，在登陆时，判断职位和部门是否是0*/
       }
        return selectEmployee(model,session);
    }
    @RequestMapping("/selectOneEmployee")
    public String selectOneEmployee(Employee employee,Model model, HttpServletRequest request, HttpSession session){
        List<Employee> employees= (List<Employee>) session.getAttribute("allEmployees");
        for (Employee e:employees) {
            if (e.geteId()==employee.geteId()){
                //model.addAttribute("oneEmployee",e);
                session.setAttribute("oneEmployee",e);
            }
        }
        return "selectOneEmployee";
    }
    @RequestMapping("/selectOneEmployee1")
    public String selectOneEmployee1(Employee employee,Model model, HttpServletRequest request, HttpSession session){
        List<Employee> employees= (List<Employee>) session.getAttribute("allEmployees");
        for (Employee e:employees) {
            if (e.geteId()==employee.geteId()){
                //model.addAttribute("oneEmployee",e);
                session.setAttribute("oneEmployee",e);
            }
        }
        return "selectOneEmployee1";
    }
    @RequestMapping("/skipEmployeeInfo")
    public String skipEmployeeInfo(Employee employee,Model model, HttpSession session) {
        employee= employeeService.selectById(employee);
        model.addAttribute("employee",employee);
        List<Department> departments=departmentService.selectAllDepartment();
        for (Department d:departments) {
            if (d.getdId()==employee.geteDid()){
                model.addAttribute("department",d);
                for (Position p:d.getPositions()) {
                    if (p.getpId()==employee.getePid()){
                        model.addAttribute("position",p);
                    }
                }
            }
        }
        return "employeeInfo";
    }
    @RequestMapping("/queryAllemployee3")
    public String queryAllemployee3( Employee employee,Model model,HttpSession session){

        List<Department> lists=departmentService.selectAllDepartment();
        model.addAttribute("allDepartments",lists);
        model.addAttribute("allPositions",positionService.selectAllPosition());
        model.addAttribute("allEmployees",employeeService.selectAllEmployee());
        model.addAttribute("employee",employee);
        return "queryAllemployee3";
    }
    @RequestMapping("/updateEmployee1")
    public String updateEmployee1( Employee employee, Model model, HttpServletRequest request, HttpSession session){
        employeeService.updateByID(employee);
        employee=employeeService.selectById(employee);
        model.addAttribute("employee",employee);
        model.addAttribute("error","修改成功");
        return "employeeInfo";
    }
}
