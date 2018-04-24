package com.iotek.controller;

import com.iotek.biz.ResumeDdService;
import com.iotek.biz.ResumeService;
import com.iotek.dao.ResumeDdMapper;
import com.iotek.dao.ResumeMapper;
import com.iotek.model.Resume;
import com.iotek.model.ResumeDd;
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
import java.util.List;

/**
 * Created by Administrator on 2018/4/21.
 */

@Controller
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private ResumeDdService resumeDdService;
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
    @RequestMapping("/deleteResume1")
    public void deleteResume1(long resumeRId, HttpServletRequest request, HttpSession session, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().write("<script language='javascript'>if(confirm('是否删除此简历'))" +
                    "{window.location.href='deleteResume?resumeRId="+resumeRId+"'}else{window.location.href='skipWelcome'}</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/deleteResume")
    public String deleteResume(long resumeRId, HttpServletRequest request, HttpSession session, HttpServletResponse response){
          Resume resume=new Resume(resumeRId);
          User user=(User)session.getAttribute("user");
          resume.setuId(user.getuId());
        if (resumeService.deleteResumeByID(resume)!=0){
            session.setAttribute("resume",resumeService.selectResume(resume));
            return "welcome";
        }else{
            try {
                response.getWriter().write("<script language='javascript'>if(confirm('是否删除此简历'))" +
                        "{window.load.href=''}else{window.load.href=''}alert(decodeURIComponent('删除失败'))</script>");
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
    @RequestMapping("/selectResume")
    public String selectResume(Resume resume, ResumeDd resumeDd,HttpServletRequest request, HttpSession session, HttpServletResponse response){
        List<ResumeDd> resumeDds= (List<ResumeDd>) session.getAttribute("resumeDds");
        for (ResumeDd r:resumeDds){
            if (r.getRdId()==resumeDd.getRdId()){
                r.setRdState("已查看");
                resumeDdService.updateByID(r);
            }
        }
        session.setAttribute("oneResume",resumeService.selectOneResume(resume));
        session.setAttribute("resumeDd",resumeDd);
        return "resume1";
    }
}
