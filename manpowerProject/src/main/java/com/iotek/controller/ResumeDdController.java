package com.iotek.controller;

import com.iotek.biz.ResumeDdService;
import com.iotek.model.ResumeDd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;


/**
 * Created by Administrator on 2018/4/22.
 */
@Controller
public class ResumeDdController {
    @Autowired
    private ResumeDdService resumeDdService;
    @RequestMapping("/addResumeDd")
    public String addResumeDd(ResumeDd resumeDd,int permission, HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        if (permission == 2) {
            session.setAttribute("error2","请先登陆，才能获取权限，如果没有账号，请先注册");
            return "../../index";
        }else{
            resumeDd.setRdState("未读");
            resumeDd.setRdTime(new Date());//可能有误
            resumeDdService.addResumeDd(resumeDd);
            session.setAttribute("succeed","简历投递成功");
            return "recruitmentInformations";
        }
    }
    @RequestMapping("/selectResumeDd")
    public String selectResumeDd(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
         session.setAttribute("resumeDds",resumeDdService.selectAllResumeDd());
        return "resumeDd";
    }
    @RequestMapping("/deleteResumeDd")
    public String deleteResumeDd(ResumeDd resumeDd,HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        resumeDdService.deleteByID(resumeDd);
        session.setAttribute("resumeDds",resumeDdService.selectAllResumeDd());
        return "resumeDd";
    }

}
