package com.iotek.controller;

import com.iotek.biz.*;

import com.iotek.model.Employee;
import com.iotek.model.RecruitmentInformation;
import com.iotek.model.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/4/20.
 */
@Controller
public class PagesController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private RecruitmentInformationService recruitmentInformationService;
    @RequestMapping("/skipLogin")
    public String skipLogin(String myselect ){
        if (myselect.equals("opt1")) {
            return "login";
        }else if(myselect.equals("opt2")){
            return "administrator";
        }else{
            return "employee";
        }
    }
    @RequestMapping("/skipWelcome")
    public String skipWelcome(){
        return "welcome";
    }
    @RequestMapping("/skipUserRegister")
    public String skipUserRegister(){
        return "userRegister";
    }
    @RequestMapping("/skipResume")
    public String skipResume(int permission, Model model){
        if (permission==2){
            model.addAttribute("error2","请先登陆，才能获取权限，如果没有账号，请先注册");
            return "../../index";
        }else{

            return "resume";
        }
    }
    @RequestMapping("/skipQueryResume")
    public String skipQueryResume(int permission,int resume, Model model, HttpSession session){
        if (permission==2){
           model.addAttribute("error2","请先登陆，才能获取权限，如果没有账号，请先注册");
            return "../../index";
        }else{
            List<Resume> list= (List<Resume>) session.getAttribute("resume");
            for (Resume r:list) {
                if (r.getrId()==resume){
                    session.setAttribute("resume1",r);
                    return "queryResume";
                }
            }
            return "queryResume";
        }
    }
    @RequestMapping("/skipAdministratorPages")
    public String skipAdministratorPages(){
        return "administratorpages";
    }
    @RequestMapping("/skipRecruit")
    public String skipRecruit(){
        return "recruit";
    }
    @RequestMapping("/skipAddEmployee")
    public String skipAddEmployee(Resume resume,RecruitmentInformation recruitmentInformation, Model model, HttpServletRequest request, HttpSession session){
        model.addAttribute("rInf",recruitmentInformationService.selectByID(recruitmentInformation));
        session.setAttribute("addResume",resumeService.selectOneResume(resume));
        session.setAttribute("allDepartments",departmentService.selectAllDepartment());
        session.setAttribute("allPositions",positionService.selectAllPosition());
        return "addEmployee";
    }
    @RequestMapping("/skipResumeDd")
    public String skipResumeDd(HttpSession session){
        return "resumeDd";
    }
    @RequestMapping("/skipAdmRecruitmentInfor")
    public String skipAdmRecruitmentInfor(){
        return "admRecruitmentInfor";
    }
    @RequestMapping("/skipDepartment")
    public String skipDepartment(){
        return "department";
    }
    @RequestMapping("/skipSelectPosition")
    public String skipSelectPosition(){
        return "selectPostion";
    }
    @RequestMapping("/skipSelectDepartment")
    public String skipSelectDepartment(){
        return "selectDepartment";
    }
    @RequestMapping("/skipskipDep_position")
    public String skipDep_position(){
        return "dep_position";
    }
    @RequestMapping("/skipPosition")
    public String skipPosition(){
        return "position";
    }
    @RequestMapping("/skipAllTrain")
    public String skipAllTrain(){
        return "allTrains";
    }
    @RequestMapping("/skipTrain")
    public String skipTrain(){
        return "train";
    }
    @RequestMapping("/skipAdm_empl")
    public String skipAdm_empl(){
        return "adm_empl";
    }
    @RequestMapping("/skipSelectEmployee")
    public String skipSelectEmployee(){
        return "selectEmployee";
    }
    @RequestMapping("/skipRewardPunishment")
    public String skipRewardPunishment(){
        return "rewardPunishment";
    }
    @RequestMapping("/skipSalary")
    public String skipSalary(){
        return "salary";
    }
    @RequestMapping("/skipIndex")
    public String skipIndex(){
        return "../../index";
    }
    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("error2","你还不是用户，没有权限，请先去注册用户");
        return "../../index";
    }
    @RequestMapping("/skipEmployeePages")
    public String skipEmployeePages(Employee employee,Model model) {
        List<Employee> list=employeeService.selectAllEmployee();
        for (Employee e:list){
            if (e.geteId()==employee.geteId()){
               model.addAttribute("employee",e);
            }
        }
        return "employeePages";
    }
    @RequestMapping("/skipAllPages")
    public String skipAllPages(Employee employee,Model model) {
        List<Employee> list=employeeService.selectAllEmployee();
        for (Employee e:list){
            if (e.geteId()==employee.geteId()){
                model.addAttribute("employee",e);
            }
        }
        return "allPages";
    }
    @RequestMapping("/skipQueryAllPages")
    public String skipQueryAllPages(Employee employee,Model model) {
        model.addAttribute("employee",employee);
        return "queryAllDepartment";
    }
    @RequestMapping("/skipAll_dep_pos")
    public String skipAll_dep_pos(Employee employee,Model model) {
        model.addAttribute("employee",employee);
        return "all_dep_pos";
    }
    @RequestMapping("/skipAll_dep_pos1")
    public String skipAll_dep_pos1(Employee employee,Model model) {
        model.addAttribute("employee",employee);
        return "all_dep_pos1";
    }
}
