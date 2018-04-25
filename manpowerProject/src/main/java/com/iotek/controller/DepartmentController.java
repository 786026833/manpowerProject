package com.iotek.controller;

import com.iotek.biz.DepartmentService;
import com.iotek.biz.PositionService;
import com.iotek.model.Department;
import com.iotek.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PositionService positionService;
    @RequestMapping("/addDepartment")
    public  String addDepartment(Department department, HttpSession session){
        List<Department> departments=departmentService.selectAllDepartment();
        for (Department d:departments) {
            if(d.getdName().equals(department.getdName())){
               session.setAttribute("error7","部门已存在，不能创建");
                return "department";
            }
        }
        department.setdTime(new Date());
        departmentService.addDepartment(department);
        session.setAttribute("error8","部门创建成功");
        return "department";
    }
    @RequestMapping("/selectDepartment")
    public  String selectDepartment( HttpSession session){
        List<Department> departments=departmentService.selectAllDepartment();
        session.setAttribute("departments",departments);
        return "selectDepartment";
    }
    @RequestMapping("/addD_Position")
    public  String  addD_Position( HttpSession session){
        List<Department> departments=departmentService.selectAllDepartment();
        session.setAttribute("departments",departments);
        return "position";
    }

    @RequestMapping("/deleteDepartment")
    public  String deleteDepartment( Department department,HttpSession session){
        List<Position> positions =positionService.selectAllPosition();
        for (Position p:positions) {
            if (p.getdId()==department.getdId()){
                if (p.getEmployees()!=null){
                    session.setAttribute("error7","此部门还有员工存在，不能撤销");
                    return selectDepartment(session);
                }
            }
        }
        departmentService.deleteById(department);
        session.setAttribute("error7","部门撤销成功");
        return selectDepartment(session);

    }
    @RequestMapping("/updateteDepartment")
    public  String updateteDepartment( Department department,HttpSession session){
        List<Department> departments=departmentService.selectAllDepartment();
        for (Department d:departments) {
            if(d.getdName().equals(department.getdName())){
                session.setAttribute("error7","部门已存在，不能改成此名字");
                return selectDepartment(session);
            }
        }
        departmentService.updateById(department);
        session.setAttribute("error7","部门修改成功");
        return selectDepartment(session);
    }

}
