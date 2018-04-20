package com.iotek.controller;

import com.iotek.biz.UserService;
import com.iotek.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/4/20.
 */
@Controller
public class UserController {
    private UserService userService;
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request, HttpSession session){
        user=userService.selectByNamePass(user);
         if (user!=null){
             session.setAttribute("user",user);
             return "welcome";
         }else {
             session.setAttribute("error","用户名或密码错误");
             return "../../index";
         }
    }
    @RequestMapping("/register")
    public String register(User user, HttpServletRequest request, HttpSession session){
        System.out.println(user.toString());
        if (null==userService.selectByName(user)){
            userService.addUser(user);
            return "login";
        }else {
            session.setAttribute("error","用户名已存在，不能注册");
            return "register";
        }
    }
}
