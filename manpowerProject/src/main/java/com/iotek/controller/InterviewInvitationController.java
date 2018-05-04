package com.iotek.controller;

import com.iotek.biz.InterviewInvitationService;
import com.iotek.biz.ResumeDdService;
import com.iotek.model.InterviewInvitation;
import com.iotek.model.ResumeDd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2018/4/23.
 */
@Controller
public class InterviewInvitationController {
    @Autowired
    private InterviewInvitationService iis;
    @Autowired
    private ResumeDdService resumeDdService;

    @RequestMapping("/addInterviewInvitation")
    public String addInterviewInvitation(InterviewInvitation interviewInvitation,
    HttpServletRequest request,HttpServletResponse response,
    HttpSession session){
       interviewInvitation.setiInterviewTime(interviewInvitation.getiInterviewTime().replace('T',' '));
       interviewInvitation.setiState((long)1);//1是未确认面试，0是确认面试
       iis.addInterviewInvitation(interviewInvitation);
       session.setAttribute("error3","发送成功");
       return "resumeDd";
   }
    @RequestMapping("/selectInterviewInvitation")
    public String selectInterviewInvitation(InterviewInvitation interviewInvitation,
        int permission, HttpSession session, Model model) {
        if (permission == 2) {
            model.addAttribute("error2","请先登陆，才能获取权限，如果没有账号，请先注册");
            return "../../index";
        } else {

            List<InterviewInvitation> interviewInvitations = iis.selectAllInterviewInvitation(interviewInvitation);
            session.setAttribute("interviewInvitations", interviewInvitations);
            return "interviewInvitation";
        }
    }
    @RequestMapping("/updateInterviewInvitation")
    public String updateInterviewInvitation(int iId, HttpSession session) {
            List<InterviewInvitation> interviewInvitations = (List<InterviewInvitation>) session.getAttribute("interviewInvitations");
        for (InterviewInvitation i:interviewInvitations ) {
            if (i.getiId()==iId){
                i.setiState((long)0);
                iis.updateById(i);
                List<ResumeDd> resumeDds=resumeDdService.selectAllResumeDd();
                for (ResumeDd rd:resumeDds) {
                    if (rd.getrId()==i.getrId()){
                        rd.setRdInterview("已面试");
                        resumeDdService.updateByID(rd);
                    }
                }
            }
        }
        session.setAttribute("interviewInvitations", interviewInvitations);
        return "interviewInvitation";
    }
}
