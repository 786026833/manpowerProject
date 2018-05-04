package com.iotek.controller;

import com.iotek.biz.DepartmentService;
import com.iotek.biz.PositionService;
import com.iotek.biz.RewardPunishmentService;
import com.iotek.model.Department;
import com.iotek.model.Employee;
import com.iotek.model.RewardPunishment;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
@Controller
public class RewardPunishmentController {
    @Autowired
    private RewardPunishmentService rps;
    @Autowired
    private PositionService positionService;
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping("/skipAddRewardPunishment")
    public String skipAddRewardPunishment(Model model){
        List<Department> departments=departmentService.selectAllDep_pos_empl();
        model.addAttribute("departments",departments);
        return "addRewardPunishment";
    }
    @RequestMapping("/addRewardPunishment1")
        public String addRewardPunishment1(RewardPunishment rewardPunishment, Model model){
       rewardPunishment.setRpTime(new Date());
        if (rewardPunishment.getReName().equals("惩罚")){
            rewardPunishment.setRpSal(-+rewardPunishment.getRpSal());
        }
        rps.addRewardPunishment(rewardPunishment);
        model.addAttribute("rp","添加成功");
        return "rewardPunishment";
    }
    @RequestMapping("/deleteRewardPunishment")
    public String deleteRewardPunishment(RewardPunishment rewardPunishment,Model model,HttpSession session){
        rps.deleteByID(rewardPunishment);
        model.addAttribute("rp","删除成功");
        return skipAllRewardPunishment(model,session);
    }
    @RequestMapping("/skipUpdateRewardPunishment")
    public String skipUpdateRewardPunishment(RewardPunishment rewardPunishment,Model model,HttpSession session){
        model.addAttribute("rewardPunishment",rps.selectByID(rewardPunishment));
        return "updateRewardPunishment";
    }
    @RequestMapping("/updateRewardPunishment")
    public String updateRewardPunishment(RewardPunishment rewardPunishment,Model model,HttpSession session){
        System.out.println(rewardPunishment.toString());
       // rewardPunishment.setRpTime(rewardPunishment.getRpTime().replace("T",""));
        if (rewardPunishment.getReName().equals("惩罚")){
            rewardPunishment.setRpSal(-+rewardPunishment.getRpSal());
        }
        rps.updateByID(rewardPunishment);
        model.addAttribute("rp","修改成功");
        return skipAllRewardPunishment(model,session);
    }
    @RequestMapping("/skipAllRewardPunishment")
    public String skipAllRewardPunishment(Model model,HttpSession session){
        List<RewardPunishment> rewardPunishments=rps.selectAllRewardPunishment();
        session.setAttribute("rps",rewardPunishments);
        return "allRewardPunishment";
    }
    @RequestMapping("/skipQueryRewardPunishment")
    public String skipQueryRewardPunishment(Employee employee,RewardPunishment rewardPunishment, Model model){
        rewardPunishment.seteId(employee.geteId());
        model.addAttribute("rewardPunishments",rps.selectByEid(rewardPunishment));
        model.addAttribute("employee",employee);
        return "queryRewardPunishment";
    }
}
