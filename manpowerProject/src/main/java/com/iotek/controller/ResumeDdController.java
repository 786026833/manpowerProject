package com.iotek.controller;

import com.iotek.biz.ResumeDdService;
import com.iotek.model.ResumeDd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;


/**
 * Created by Administrator on 2018/4/22.
 */
@Controller
public class ResumeDdController {
    @Autowired
    private ResumeDdService resumeDdService;
    @RequestMapping("/addResumeDd")
    public String addResumeDd(ResumeDd resumeDd, HttpServletRequest request, HttpSession session, HttpServletResponse response){
        resumeDd.setRdState("未读");
        resumeDd.setRdTime(new Date());//可能有误
        resumeDdService.addResumeDd(resumeDd);
        return "queryResume";
    }
}
