package com.iotek.controller;

import com.iotek.biz.DepartmentService;
import com.iotek.biz.EmployeeService;
import com.iotek.biz.PositionService;
import com.iotek.biz.TrainService;
import com.iotek.model.Department;
import com.iotek.model.Employee;
import com.iotek.model.Position;
import com.iotek.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
@Controller
public class TrainController {
    @Autowired
    private TrainService trainService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;
    @RequestMapping("/skipAddTrain")
    public String skipAddTrain(HttpSession session) {
        session.setAttribute("d",departmentService.selectAllDepartment());
        return "addTrain";
    }
    @RequestMapping("/addTrain")
    public String addTrain(String trId,Train train ,HttpSession session,Model model) {
        List<Department> departments= (List<Department>) session.getAttribute("d");
        for (Department d:departments) {
            if (Long.parseLong(trId) == d.getdId()){
                train.settTrainee(d.getdName());
                for (Position p:d.getPositions()) {
                    List<Employee> list= employeeService.selectAllEmployee();
                    for (Employee e:list) {
                        if (e.getePid()==p.getpId()) {
                            e.seteTrain((long) 1);
                            employeeService.updateByID(e);
                        }
                    }
                }
            }
        }
        trainService.addTrain(train);
        model.addAttribute("erroe","添加成功");
        return "train";
    }
    @RequestMapping("/selectTrain")
    public String selectTrain(HttpSession session,Model model){
        session.setAttribute("trains",trainService.selectByAllTrain());
        return "allTrains";
    }
    @RequestMapping("/deleteTrain")
    public String deleteTrain(Train train,HttpSession session,Model model){
        trainService.deleteByID(train);
        model.addAttribute("error","修改成功");
        return selectTrain(session,model);
    }
    @RequestMapping("/selectOneTrain")
    public String selectOneTrain(Train train, HttpSession session, Model model){
        List<Train> list= (List<Train>) session.getAttribute("trains");
        for (Train t:list) {
            if (t.gettId()==train.gettId()){
                model.addAttribute("oneTrain",t);
            }
        }

        return "addTrain1";
    }
    @RequestMapping("/updateTrain")
    public String updateTrain(Train train, HttpSession session,Model model){
        trainService.updateByID(train);
        model.addAttribute("error","修改成功");
        return selectTrain(session,model);
    }
}
