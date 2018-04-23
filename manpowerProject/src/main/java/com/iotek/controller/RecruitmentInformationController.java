package com.iotek.controller;

import com.iotek.biz.RecruitmentInformationService;
import com.iotek.model.RecruitmentInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/4/21.
 */
@Controller
public class RecruitmentInformationController {
    @Autowired
    private RecruitmentInformationService rIns;
    @RequestMapping("/selectInformation")
    public String selectInformation(int currentPage, HttpServletRequest request, HttpSession session){
        int totalRows=rIns.selectALLInformation().size();//获取记录的总数
        final int PAGESIZE=2;//每页有几条记录
        int totalPages=(int)Math.ceil((double)totalRows/PAGESIZE);//获取总页数
       // List<RecruitmentInformation> recruitmentInformations=rIns.selectInformation(currentPage,PAGESIZE);
        if (rIns.selectALLInformation()!=null){
            session.setAttribute("recruitmentInformations",rIns.selectALLInformation());
            session.setAttribute("totalPages",totalPages);
            return "recruitmentInformations";
        }else {
            session.setAttribute("error","list是空的");
            return "welcome";
        }
    }
}
