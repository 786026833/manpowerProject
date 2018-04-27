package com.iotek.controller;

import com.iotek.biz.DepartmentService;
import com.iotek.biz.RewardPunishmentService;
import com.iotek.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
@Controller
public class RewardPunishmentController {
    @Autowired
    private RewardPunishmentService rps;
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping("/skipAddRewardPunishment")
    public String skipAddRewardPunishment(Model model){
        List<Department> departments=departmentService.selectAllDep_pos_empl();
        System.out.println(departments);
        model.addAttribute("departments",departments);
        return "addRewardPunishment";
    }
}
