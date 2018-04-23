package com.iotek.controller;

import com.iotek.model.Resume;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/4/20.
 */
@Controller
public class PagesController {
    @RequestMapping("/skipLogin")
    public String skipLogin(String myselect ){
        if (myselect.equals("opt1")) {
            return "login";
        }else{
            return "administrator";
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
    public String skipResume(int permission, HttpSession session){
        if (permission==2){
            session.setAttribute("error2","请先登陆，才能获取权限，如果没有账号，请先注册");
            return "../../index";
        }else{
            return "resume";
        }
    }
    @RequestMapping("/skipQueryResume")
    public String skipQueryResume(int permission,int resume, HttpSession session){
        if (permission==2){
            session.setAttribute("error2","请先登陆，才能获取权限，如果没有账号，请先注册");
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
    @RequestMapping("/skipResumeDd")
    public String skipResumeDd(){
        return "resumeDd";
    }
}
