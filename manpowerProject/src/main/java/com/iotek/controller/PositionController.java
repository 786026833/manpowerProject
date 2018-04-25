package com.iotek.controller;

import com.iotek.biz.DepartmentService;
import com.iotek.biz.PositionService;
import com.iotek.model.Department;
import com.iotek.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/4/24.
 */
@Controller
public class PositionController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping("/addPosition")
    public String addPosition(Position position, HttpSession session){
        for (Department d:departmentService.selectAllDepartment()) {
            if (d.getdId()==position.getdId()){
                for (Position p:positionService.selectAllPosition()) {
                    if (p.getpName().equals(position.getpName())){
                        session.setAttribute("error9","本部门已经存在此职位，不能再添加");
                   return "position";
                    }
                }
            }
        }
        positionService.addPosition(position);
        session.setAttribute("error9","职位添加成功");
        return "position";
    }
    @RequestMapping("/selectPosition")
    public String selectPosition( HttpSession session){
        session.setAttribute("positions",positionService.selectAllPosition());
        return "selectPostion";
    }
    @RequestMapping("/updatePosition")
    public String updatePosition(Position position, HttpSession session){
        positionService.updateByID(position);
        session.setAttribute("error9","职位修改成功");
        return selectPosition(session);
    }
    @RequestMapping("/deletePosition")
    public String deletePosition(Position position, HttpSession session){

           if (positionService.selectByID(position).getEmployees()!=null){
               session.setAttribute("error9","此职位还有员工，职位不能删除");
               return "selectPostion";
           }
           positionService.deleteByID(position);
        session.setAttribute("error9","职位删除成功");
        return selectPosition(session);
    }
}

