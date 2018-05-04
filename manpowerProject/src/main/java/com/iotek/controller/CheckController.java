package com.iotek.controller;

import com.iotek.biz.CheckService;
import com.iotek.biz.EmployeeService;
import com.iotek.biz.PositionService;
import com.iotek.biz.RewardPunishmentService;
import com.iotek.model.Check;

import com.iotek.model.Employee;
import com.iotek.model.Position;
import com.iotek.model.RewardPunishment;
import org.joda.time.LocalDate;


import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
@Controller
public class CheckController {
    @Autowired
    private CheckService checkService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private RewardPunishmentService rewardPunishmentService;
    @RequestMapping("/addCheck")//上班打卡
    public String addCheck(long eId, Model model){
        Check check= new Check();
        Employee employee=new Employee();
        employee.seteId(eId);
        employee=employeeService.selectById(employee);
        Position position=new Position();
        RewardPunishment rewardPunishment=new RewardPunishment();
        //JAVA字符串转日期或日期转字符串 用的API是SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        SimpleDateFormat sdf2 = new SimpleDateFormat( "yyyy-MM-dd" );
        Date date1=new Date();//获取打卡时间 存到考勤
        //先判断是否打过卡 打过卡不能再打
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int date = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);//获取小时
        int minute = c.get(Calendar.MINUTE);//获取分钟
        check.seteId(eId);
        List<Check> list=checkService.selectAllCheckByEid(check);
        //先判断打卡系统是否开启
        try {
            Date date4 = sdf.parse(sdf2.format(date1)+" "+"13:00:00");
            if((date1.getTime()-date4.getTime())>0){
                model.addAttribute("error","上班打卡系统已关闭，不能打卡");
                model.addAttribute("employee",employee);
                return "employeePages";
            }else{
                //遍历所有的上班打卡时间
                for (Check ck:list) {
                    //获取上班打卡时间的日期
                    if (ck.getcWorkTime()!=null){
                        DateTimeFormatter sdf1 = DateTimeFormat.forPattern( "yyyy-MM-dd HH:mm:ss" );
                        LocalDate localDate=sdf1.parseLocalDate(sdf.format(ck.getcWorkTime()));
                        //判断今天是否打卡
                        if(localDate.getDayOfMonth()-date==0){
                            model.addAttribute("error","已经打过卡，不能在打卡");
                            model.addAttribute("employee",employee);
                            return "employeePages";
                        }
                    }
                }
                Date date5 = sdf.parse(sdf2.format(date1)+" "+"9:00:00");
                if ((date1.getTime()-date5.getTime())<0){
                    //正常上班
                    check.setcWorkTime(date1);
                    check.seteId(eId);
                    checkService.addCheck(check);
                    model.addAttribute("error","上班正常打卡");
                }else{
                        //上班迟到（未超过3小时）
                        //将时间字符串转成时间
                        Date date3 = sdf.parse(sdf2.format(date1)+" "+"9:00:00");
                        if ((date1.getTime()-date3.getTime())<3*60*60*1000){
                            check.setcWorkTime(date1);
                            check.setcLate("迟到");
                            check.seteId(eId);
                            checkService.addCheck(check);
                            //扣钱 生成惩罚信息  迟到扣50
                            rewardPunishment.seteId(eId);
                            rewardPunishment.setRpTime(date1);
                            rewardPunishment.setRpSal((long)-50);
                            rewardPunishment.setRpCause("迟到");
                            rewardPunishment.setReName("惩罚");
                            rewardPunishmentService.addRewardPunishment(rewardPunishment);
                            model.addAttribute("error","上班迟到打卡");
                        }else {
                            //旷工（超过3小时）
                            check.setcWorkTime(date1);
                            check.setcAbsenteeism("旷工");
                            check.seteId(eId);
                            checkService.addCheck(check);
                            //扣钱 生成惩罚信息
                            rewardPunishment.seteId(eId);
                            rewardPunishment.setRpTime(date1);
                            rewardPunishment.setReName("惩罚");
                            position.setpId(employee.getePid());
                            position = positionService.selectByID1(position);
                            rewardPunishment.setRpSal(-position.getpSalary() / 30);
                            rewardPunishment.setRpCause("旷工");
                            rewardPunishmentService.addRewardPunishment(rewardPunishment);
                            model.addAttribute("error", "打卡时间超过3小时，你旷工了");
                        }
                }
                model.addAttribute("employee",employee);
                return "employeePages";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        model.addAttribute("employee",employee);
        return "employeePages";
    }
    @RequestMapping("/addCheck1")//下班打卡
    public String addCheck1(long eId, Model model){
        Check check= new Check();
        Employee employee=new Employee();
        employee.seteId(eId);
        employee=employeeService.selectById(employee);
        Position position=new Position();
        RewardPunishment rewardPunishment=new RewardPunishment();
        //JAVA字符串转日期或日期转字符串 用的API是SimpleDateFormat
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        SimpleDateFormat sdf2 =   new SimpleDateFormat( "yyyy-MM-dd" );
        Date date1=new Date();//获取打卡时间 存到考勤
        //先判断是否打过卡 打过卡不能再打
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int date = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);//获取小时
        int minute = c.get(Calendar.MINUTE);//获取分钟
        //先判断下班打卡系统是否开启
        try {
            Date date4 = sdf.parse(sdf2.format(date1)+" "+"9:00:00");
            if (date1.getTime()-date4.getTime()<0){
                model.addAttribute("error","下班打卡系统还未开启");
                model.addAttribute("employee",employee);
                return "employeePages";
            }else{
                check.seteId(eId);
                List<Check> list=checkService.selectAllCheckByEid(check);//获取今天的打卡记录
                //遍历所有的下班打卡时间
                for (Check ck:list) {
                    if (ck.getcWorkTime()!=null){
                        DateTimeFormatter sdf1 = DateTimeFormat.forPattern( "yyyy-MM-dd HH:mm:ss" );
                        LocalDate localDate=sdf1.parseLocalDate(sdf.format(ck.getcWorkTime()));
                        //判断今天是否打卡
                        if(localDate.getDayOfMonth()-date==0){
                            check=ck;
                            //判断下班卡是否打过
                            if (ck.getcOffworkTine()!=null){
                                model.addAttribute("error","已经打过下班卡，不能再打卡");
                                model.addAttribute("employee",employee);
                                return "employeePages";
                            }
                        }
                    }
                }
                System.out.println(check.toString());
                if (check.getcId()==null){
                    Date date3 = sdf.parse(sdf2.format(date1)+" "+"18:00:00");
                    if ((date1.getTime()-date3.getTime())>0){
                        //正常下班
                        if ((date1.getTime()-date3.getTime())<60*60*1000) {
                            check.setcOffworkTine(date1);
                            check.seteId(eId);
                            checkService.addCheck(check);
                            model.addAttribute("error","下班正常打卡");
                        }else{
                            //加班
                            check.setcOffworkTine(date1);
                            check.seteId(eId);
                            checkService.addCheck(check);
                            //加钱 生成奖励信息
                            position.setpId(employee.getePid());
                            position=positionService.selectByID1(position);
                            //截取数值的精度
                            double d=position.getpSalary()/30/8*((date1.getTime()-date3.getTime())/1000/60/60);
                            double db=(double) Math.round(d*100)/100;
                            rewardPunishment.setRpSal(db);
                            rewardPunishment.seteId(eId);
                            rewardPunishment.setRpTime(date1);
                            rewardPunishment.setRpCause("加班");
                            rewardPunishment.setReName("奖励");
                            rewardPunishmentService.addRewardPunishment(rewardPunishment);
                            model.addAttribute("error", "加班打卡");
                        }
                        model.addAttribute("employee",employee);
                        return "employeePages";
                    }else{
                        //下班早退（未超过3小时）
                        //将时间字符串转成时间
                        if ((date3.getTime()-date1.getTime())<3*60*60*1000){
                            check.setcOffworkTine(date1);
                            check.setcLeave("早退");
                            check.seteId(eId);
                            checkService.addCheck(check);
                            rewardPunishment.seteId(eId);
                            rewardPunishment.setRpTime(date1);
                            rewardPunishment.setRpSal((long)-50);
                            rewardPunishment.setRpCause("早退");
                            rewardPunishmentService.addRewardPunishment(rewardPunishment);
                            model.addAttribute("error","下班早退打卡");
                        }else{
                            //旷工（超过3小时）
                            check.setcOffworkTine(date1);
                            check.setcAbsenteeism("旷工");
                            check.seteId(eId);
                            checkService.addCheck(check);
                            rewardPunishment.seteId(eId);
                            rewardPunishment.setRpTime(date1);
                            rewardPunishment.setReName("惩罚");
                            position.setpId(employee.getePid());
                            position=positionService.selectByID1(position);
                            rewardPunishment.setRpSal(-position.getpSalary()/30);
                            rewardPunishment.setRpCause("旷工");
                            rewardPunishmentService.addRewardPunishment(rewardPunishment);
                            model.addAttribute("error","早退时间超过3小时，你旷工了");
                        }
                        model.addAttribute("employee",employee);
                        return "employeePages";
                    }
                }else{
                    Date date5 = sdf.parse(sdf2.format(date1)+" "+"18:00:00");
                    if ((date1.getTime()-date5.getTime())>0){
                        try {
                            //正常下班
                            Date date3 = sdf.parse(sdf2.format(date1)+" "+"18:00:00");
                            if ((date1.getTime()-date3.getTime())<60*60*1000) {
                                check.setcOffworkTine(date1);
                                checkService.updateByID(check);
                                model.addAttribute("error","下班正常打卡");
                            }else{
                                //加班
                                check.setcOffworkTine(date1);
                                checkService.updateByID(check);
                                //加钱 生成奖励信息
                                position.setpId(employee.getePid());
                                position=positionService.selectByID1(position);
                                //截取数值的精度
                                double d=position.getpSalary()/30/8*((date1.getTime()-date3.getTime())/1000/60/60);
                                double db=(double) Math.round(d*100)/100;
                                rewardPunishment.setRpSal(db);
                                rewardPunishment.seteId(eId);
                                rewardPunishment.setRpTime(date1);
                                rewardPunishment.setRpCause("加班");
                                rewardPunishment.setReName("奖励");
                                rewardPunishmentService.addRewardPunishment(rewardPunishment);
                                model.addAttribute("error", "加班打卡");
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        model.addAttribute("employee",employee);
                        return "employeePages";
                    }else{
                        try {
                            //下班早退（未超过3小时）
                            //将时间字符串转成时间
                            Date date3 = sdf.parse(sdf2.format(date1)+" "+"18:00:00");
                            if ((date3.getTime()-date1.getTime())<3*60*60*1000){
                                //判断今天是否已经矿工，有旷工就不扣钱，没有则扣钱 生成惩罚信息
                                if ("旷工".equals(check.getcAbsenteeism())){
                                    model.addAttribute("error","下班早退打卡");
                                }else if ("迟到".equals(check.getcLate())){
                                    rewardPunishment.seteId(eId);
                                    rewardPunishment.setRpTime(date1);
                                    rewardPunishment.setReName("惩罚");
                                    position.setpId(employee.getePid());
                                    position=positionService.selectByID1(position);
                                    rewardPunishment.setRpSal(-(long)50);
                                    rewardPunishment.setRpCause("早退");
                                    rewardPunishmentService.addRewardPunishment(rewardPunishment);
                                    model.addAttribute("error","下班早退打卡");
                                }else{
                                    rewardPunishment.seteId(eId);
                                    rewardPunishment.setRpTime(date1);
                                    rewardPunishment.setReName("惩罚");
                                    position.setpId(employee.getePid());
                                    position=positionService.selectByID1(position);
                                    rewardPunishment.setRpSal(-position.getpSalary()/30);
                                    rewardPunishment.setRpCause("早退");
                                    rewardPunishmentService.addRewardPunishment(rewardPunishment);
                                    model.addAttribute("error","下班早退打卡");
                                }
                                check.setcOffworkTine(date1);
                                check.setcLeave("早退");
                                checkService.updateByID(check);
                                model.addAttribute("employee",employee);
                                return "employeePages";
                            }else{
                                //判断今天是否已经矿工，有旷工就不扣钱，没有则扣钱 生成惩罚信息
                                if ("旷工".equals(check.getcAbsenteeism())){
                                    model.addAttribute("error","早退时间超过3小时，你旷工了");
                                }else if ("迟到".equals(check.getcLate())){
                                    rewardPunishment.seteId(eId);
                                    rewardPunishment.setRpTime(date1);
                                    rewardPunishment.setReName("惩罚");
                                    position.setpId(employee.getePid());
                                    position=positionService.selectByID1(position);
                                    rewardPunishment.setRpSal((-position.getpSalary()/30)+50);
                                    rewardPunishment.setRpCause("旷工");
                                    rewardPunishmentService.addRewardPunishment(rewardPunishment);
                                    model.addAttribute("error","早退时间超过3小时，你旷工了");
                                }else{
                                    rewardPunishment.seteId(eId);
                                    rewardPunishment.setRpTime(date1);
                                    rewardPunishment.setReName("惩罚");
                                    position.setpId(employee.getePid());
                                    position=positionService.selectByID1(position);
                                    rewardPunishment.setRpSal(-position.getpSalary()/30);
                                    rewardPunishment.setRpCause("旷工");
                                    rewardPunishmentService.addRewardPunishment(rewardPunishment);
                                    model.addAttribute("error","早退时间超过3小时，你旷工了");
                                }
                                //旷工（超过3小时）
                                check.setcOffworkTine(date1);
                                check.setcAbsenteeism("旷工");
                                checkService.updateByID(check);
                                model.addAttribute("employee",employee);
                                return "employeePages";
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        model.addAttribute("employee",employee);
        return "employeePages";
    }
    @RequestMapping("/queryEmplCheck")//下班打卡
    public String queryEmplCheck(Employee employee, Model model){
        Check check=new Check();
        check.seteId(employee.geteId());
        List<Check> checks=checkService.selectAllCheckByEid(check);
        model.addAttribute("checks",checks);
        model.addAttribute("employee",employee);
        return "queryEmplCheck";
    }
    @RequestMapping("/skipSelectCheck")
    public String skipSelectCheck(Model model){
        List<Check> checks=checkService.selectAllCheck();
        model.addAttribute("checks",checks);
        return "selectCheck";
    }

}
