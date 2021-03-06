package com.iotek.controller;

import com.iotek.biz.EmployeeService;
import com.iotek.biz.ResumeService;
import com.iotek.biz.UserService;
import com.iotek.model.Employee;
import com.iotek.model.Resume;
import com.iotek.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2018/4/20.
 * 管理员的口令是 sss
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/login")
    public String login(User user, String auto,String command, HttpServletRequest request, HttpSession session, HttpServletResponse response){
        if (command.equals("sss")){
            user=userService.selectByNamePass(user);
            if (user!=null){
                //判断是否勾选记住密码
                if (auto!=null){
                    try {
                        String name= URLEncoder.encode(user.getuName(),"UTF-8");
                        String pass= URLEncoder.encode(user.getuPass(),"UTF-8");
                        Cookie cookie_userName=new Cookie("administratorName",name);
                        Cookie cookie_userPwd=new Cookie("administratorPwd",pass);
                        //设置cookie的持久化时间
                        cookie_userName.setMaxAge(60*60*24*4);
                        cookie_userPwd.setMaxAge(60*60*24*4);
                        //设置cookie的携带路径
                        cookie_userName.setPath(request.getContextPath());//设定无论访问本网站的哪个服务 都可以直接登录   可有可无
                        cookie_userPwd.setPath(request.getContextPath());//因为都在web工程下
                        response.addCookie(cookie_userName);
                        response.addCookie(cookie_userPwd);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    // user=userService.selectByID(user);
                    Resume resume=new Resume();
                    resume.setuId(user.getuId());
                    session.setAttribute("resume",resumeService.selectResume(resume));
                    session.setAttribute("user",user);
                    return "administratorpages";
                }else{
                    Resume resume=new Resume();
                    resume.setuId(user.getuId());
                    session.setAttribute("resume",resumeService.selectResume(resume));
                    session.setAttribute("user",user);
                    return "administratorpages";
                }
            }else {
                session.setAttribute("error","用户名或密码错误");
                return "administrator";
            }
        }else{
            user=userService.selectByNamePass(user);
            if (user!=null){
                //判断是否勾选记住密码
                if (auto!=null){
                    try {
                        String name= URLEncoder.encode(user.getuName(),"UTF-8");
                        String pass= URLEncoder.encode(user.getuPass(),"UTF-8");
                        Cookie cookie_userName=new Cookie("userName",name);
                        Cookie cookie_userPwd=new Cookie("userPwd",pass);
                        //设置cookie的持久化时间
                        cookie_userName.setMaxAge(60*60*24*4);
                        cookie_userPwd.setMaxAge(60*60*24*4);
                        //设置cookie的携带路径
                        cookie_userName.setPath(request.getContextPath());//设定无论访问本网站的哪个服务 都可以直接登录   可有可无
                        cookie_userPwd.setPath(request.getContextPath());//因为都在web工程下
                        response.addCookie(cookie_userName);
                        response.addCookie(cookie_userPwd);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    // user=userService.selectByID(user);
                    Resume resume=new Resume();
                    resume.setuId(user.getuId());
                    session.setAttribute("resume",resumeService.selectResume(resume));
                    session.setAttribute("user",user);
                    return "welcome";
                }else{
                    Resume resume=new Resume();
                    resume.setuId(user.getuId());
                    session.setAttribute("resume",resumeService.selectResume(resume));
                    session.setAttribute("user",user);
                    return "welcome";
                }
            }else {
                session.setAttribute("error","用户名或密码错误");
                return "login";
            }
        }
    }
    @RequestMapping("/login1")
    public String login1(Employee employee, String auto, HttpServletRequest request,
                         HttpSession session, HttpServletResponse response,Model model){

            employee=employeeService.selectByNamePass(employee);
            if (employee!=null){
                //判断是否勾选记住密码
                if (auto!=null){
                    try {
                        String name= URLEncoder.encode(employee.geteName(),"UTF-8");
                        String pass= URLEncoder.encode(employee.getePass(),"UTF-8");
                        Cookie cookie_emplName=new Cookie("employeeName",name);
                        Cookie cookie_emplPwd=new Cookie("employeePwd",pass);
                        //设置cookie的持久化时间
                        cookie_emplName.setMaxAge(60*60*24*4);
                        cookie_emplPwd.setMaxAge(60*60*24*4);
                        //设置cookie的携带路径
                        cookie_emplName.setPath(request.getContextPath());//设定无论访问本网站的哪个服务 都可以直接登录   可有可无
                        cookie_emplPwd.setPath(request.getContextPath());//因为都在web工程下
                        response.addCookie(cookie_emplName);
                        response.addCookie(cookie_emplPwd);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    // user=userService.selectByID(user);

                   model.addAttribute("employee",employee);
                    return "employeePages";
                }else{

                    model.addAttribute("employee",employee);
                    return "employeePages";
                }
            }else {
                model.addAttribute("error","账号或密码错误");
                return "employee";
            }
    }
    @RequestMapping("/autoLogin")
    public String autoLogin(String command, HttpServletRequest request, HttpSession session, HttpServletResponse response) throws ServletException, IOException {
        //定义 用户名和密码
        String cookie_userName=null;
        String cookie_userPwd=null;
        //获取cookie 数组
        Cookie[] cookies=request.getCookies();
        if (command.equals("sss")){
            if (cookies!=null){
                for (Cookie cookie:cookies ) {
                    if ("administratorPwd".equals(cookie.getName())){
                        cookie_userPwd=cookie.getValue();
                        cookie_userPwd= URLDecoder.decode(cookie_userPwd, "UTF-8");
                    }
                    if ("administratorName".equals(cookie.getName())){
                        cookie_userName=cookie.getValue();
                        cookie_userName= URLDecoder.decode(cookie_userName, "UTF-8");
                    }
                }
                //判断用户名和密码是否为空
                if (cookie_userName!=null&&cookie_userPwd!=null){
                    User user=new User(cookie_userName,cookie_userPwd);
                    //调用登陆方法
                    User user1= userService.selectByNamePass(user);
                    if (user1!=null) {
                        Resume resume=new Resume();
                        resume.setuId(user1.getuId());
                        session.setAttribute("resume",resumeService.selectResume(resume));
                        session.setAttribute("user", user1);
                        return  "administratorpages";
                    }else{
                        return "administrator";
                    }
                }
            }
            return "administrator";
        }else{
            if (cookies!=null){
                for (Cookie cookie:cookies ) {
                    if ("userPwd".equals(cookie.getName())){
                        cookie_userPwd=cookie.getValue();
                        cookie_userPwd= URLDecoder.decode(cookie_userPwd, "UTF-8");
                    }
                    if ("userName".equals(cookie.getName())){
                        cookie_userName=cookie.getValue();
                        cookie_userName= URLDecoder.decode(cookie_userName, "UTF-8");
                    }
                }
                //判断用户名和密码是否为空
                if (cookie_userName!=null&&cookie_userPwd!=null){
                    User user=new User(cookie_userName,cookie_userPwd);
                    //调用登陆方法
                    User user1= userService.selectByNamePass(user);
                    if (user1!=null) {
                        Resume resume=new Resume();
                        resume.setuId(user1.getuId());
                        session.setAttribute("resume",resumeService.selectResume(resume));
                        session.setAttribute("user", user1);
                        return  "welcome";
                    }else{
                        return "login";
                    }
                }
            }
            return "login";
        }
    }
    @RequestMapping("/register")
    public String register(User user, HttpServletRequest request, HttpSession session){

        if (null==userService.selectByName(user)){
            userService.addUser(user);
            return "login";
        }else {
            session.setAttribute("error1","用户名已存在，不能注册");
            return "userRegister";
        }
    }
    @RequestMapping("/autoLogin1")
    public String autoLogin1(HttpServletRequest request, HttpSession session, HttpServletResponse response,Model model) throws ServletException, IOException {
        //定义 用户名和密码
        String cookie_emplName=null;
        String cookie_emplPwd=null;
        //获取cookie 数组
        Cookie[] cookies=request.getCookies();
            if (cookies!=null){
                for (Cookie cookie:cookies ) {
                    if ("employeePwd".equals(cookie.getName())){
                        cookie_emplPwd=cookie.getValue();
                        cookie_emplPwd= URLDecoder.decode(cookie_emplPwd, "UTF-8");
                    }
                    if ("employeeName".equals(cookie.getName())){
                        cookie_emplName=cookie.getValue();
                        cookie_emplName= URLDecoder.decode(cookie_emplName, "UTF-8");
                    }
                }
                //判断用户名和密码是否为空
                if (cookie_emplName!=null&&cookie_emplPwd!=null){
                    Employee employee=new Employee(cookie_emplName,cookie_emplPwd);
                    //调用登陆方法
                    Employee employee1= employeeService.selectByNamePass(employee);
                    if (employee1!=null) {
                        model.addAttribute("employee",employee1);
                        return "employeePages";
                    }else{
                        return "employee";
                    }
                }
            }
            return "employee";
    }
}
