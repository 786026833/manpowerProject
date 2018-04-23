package com.iotek.controller;

import com.iotek.biz.ResumeService;
import com.iotek.dao.ResumeMapper;
import com.iotek.model.Resume;
import com.iotek.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2018/4/21.
 */

@Controller
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
    @RequestMapping("/addResume")
    public String addResume(Resume resume, HttpServletRequest request, HttpSession session, HttpServletResponse response){
            if (resumeService.addResume(resume)!=0){
                session.setAttribute("resume",resumeService.selectResume(resume));
                return "welcome";
            }else{
                try {
                    response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('提交失败'))</script>");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "resume";
            }
    }
    @RequestMapping("/deleteResume")
    public String deleteResume(long resumeRId, HttpServletRequest request, HttpSession session, HttpServletResponse response){
          Resume resume=new Resume(resumeRId);
          resume.setUser((User) session.getAttribute("user"));
        if (resumeService.deleteResumeByID(resume)!=0){
            session.setAttribute("resume",resumeService.selectResume(resume));
            return "welcome";
        }else{
            try {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('删除失败'))</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "resume";
        }
    }
    @RequestMapping("/updateResume")
    public String updateResume(Resume resume, HttpServletRequest request, HttpSession session, HttpServletResponse response){
        if (resumeService.updateResumeByID(resume)!=0){
            session.setAttribute("resume",resumeService.selectResume(resume));
            return "welcome";
        }else{
            try {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('提交失败'))</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "resume";//操作失败跳转的网页
        }
    }
}
