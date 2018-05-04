package com.iotek.controller;

import com.iotek.biz.*;
import com.iotek.model.*;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
@Controller
public class SalaryController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private SalaryService salaryService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CheckService checkService;
    @Autowired
    private RewardPunishmentService rewardPunishmentService;
    @RequestMapping("/settlement")
    public String settlement(Model model){
        Salary salary=new Salary();
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
        SimpleDateFormat sdf1 = new SimpleDateFormat( "yyyy-MM" );
        Date date2=new Date();
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);//月份从0开始
        int date = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        try {
            Date date1=sdf.parse(year+"-"+(month+1)+"-"+"01");
            System.out.println(sdf.format(date1));
            System.out.println(sdf.format(date2));
            //还没到结算的日期，不能结算
            if (date2.getTime()-date1.getTime()<0){
                model.addAttribute("error","还没到结算的日期，不能结算，请于15号以后结算");
            }else{
                DateTimeFormatter sdf3 = DateTimeFormat.forPattern( "yyyy-MM-dd" );
                LocalDate localDate=null;
                List<Salary> salaryList=salaryService.selectAllSalary();
                if(salaryList.size()!=0){
                for (Salary s:salaryList) {
                    if (s.getsMonth()!=null) {
                        localDate = sdf3.parseLocalDate(sdf.format(s.getsMonth()));
                        if (localDate.getMonthOfYear() == month) {
                            model.addAttribute("error", "已经结算过工资，不能在结算");
                            return "salary";
                        }
                    }else{
                        System.out.println("kongde");
                    }
                }
                }
                //结算上个月的薪资
               //循环遍历所有员工
                List<Employee> employees=employeeService.selectAllEmployee();
                for(Employee e:employees) {
                    //查询员工的考勤记录
                    //计算月份
                    String month1=null;
                    if (month==0){
                        month1="12";
                        year=year-1;
                    }else{
                        if(month+1<10){
                            month1="0"+month;
                        }else{
                            month1=""+month;
                        }
                    }
                    //得到员工职位的基本工资
                    double money=positionService.selectByID1(new Position(e.getePid())).getpSalary();
                    Date date3=sdf1.parse(year+"-"+(month1));
                    Check check=new Check();
                    check.seteId(e.geteId());
                    //计算员工工作的天数是否超过22天  得到基本工资
                    List<Check> checks=checkService.select(check);
                    int count=0;
                    for (Check check1:checks) {
                        if (check1.getcWorkTime()!=null&&check1.getcOffworkTine()!=null){
                            localDate=sdf3.parseLocalDate(sdf.format(check1.getcWorkTime()));
                            if (localDate.getMonthOfYear()==month){
                                count++;
                            }
                        }else if(check1.getcWorkTime()==null&&check1.getcOffworkTine()!=null){
                            localDate=sdf3.parseLocalDate(sdf.format(check1.getcOffworkTine()));
                            if (localDate.getMonthOfYear()==month){
                                count++;
                            }
                        }else if(check1.getcWorkTime()!=null&&check1.getcOffworkTine()==null){
                            localDate=sdf3.parseLocalDate(sdf.format(check1.getcWorkTime()));
                            if (localDate.getMonthOfYear()==month){
                                count++;
                            }
                        }
                    }
                     if(count>=22){
                         salary.setsBaseSal(money);
                     }else{
                        salary.setsBaseSal(money/30*count);
                     }
                     //计算加班工资
                    RewardPunishment rewardPunishment=new RewardPunishment();
                     rewardPunishment.seteId(e.geteId());
                    List<RewardPunishment> rewardPunishments=rewardPunishmentService.selectByEid(rewardPunishment);
                    for (RewardPunishment r:rewardPunishments) {
                        localDate=null;
                        localDate=sdf3.parseLocalDate(sdf.format(r.getRpTime()));
                        if (localDate.getMonthOfYear()==month) {
                            if (r.getRpCause().equals("加班")) {
                                salary.setsOverSal(r.getRpSal() + salary.getsOverSal());
                            } else {
                                //计算奖惩费用
                                salary.setsPenaltySal(r.getRpSal() + salary.getsPenaltySal());
                            }
                        }
                    }
                    System.out.println("111111111111");
                    //计算绩效
                    salary.setsPerfSal(salary.getsBaseSal()*0.1);
                    //计算社保
                    salary.setsSocSal((salary.getsBaseSal()+salary.getsPenaltySal()+salary.getsOverSal()+
                    salary.getsPerfSal())*0.1);
                    //计算总工资
                    salary.setsTotalSal(salary.getsBaseSal()+salary.getsPerfSal()+salary.getsOverSal()
                    +salary.getsPenaltySal()+(-salary.getsSocSal()));
                    //添加时间
                    System.out.println("7777777777777");
                    salary.setsMonth(sdf.parse(year+"-"+month1+"-01 00:00:00"));
                    System.out.println(salary.toString());
                    salary.seteId(e.geteId());
                    salaryService.addSalary(salary);
                    model.addAttribute ("error","结算完成");
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "salary";
    }
    @RequestMapping("/querySalary")
    public String querySalary(Employee employee,Salary salary,Model model){
        model.addAttribute("salarys",salaryService.selectByEiD(salary));
        model.addAttribute("employee",employee);
       return "queryEmplSalary";
    }
}
