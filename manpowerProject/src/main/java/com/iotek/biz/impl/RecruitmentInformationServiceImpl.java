package com.iotek.biz.impl;

import com.iotek.biz.RecruitmentInformationService;
import com.iotek.dao.RecruitmentInformationMapper;
import com.iotek.model.RecruitmentInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/4/21.
 */
@Service
public class RecruitmentInformationServiceImpl implements RecruitmentInformationService {
@Autowired
private RecruitmentInformationMapper rInf;
    @Override
    public int deleteByID(RecruitmentInformation recruitmentInformation) {
        return rInf.deleteByID(recruitmentInformation);
    }

    @Override
    public int addRecruitmentInformation(RecruitmentInformation recruitmentInformation) {
        return rInf.addRecruitmentInformation(recruitmentInformation);
    }

    @Override
    public RecruitmentInformation selectByID(RecruitmentInformation recruitmentInformation) {
        return rInf.selectByID(recruitmentInformation);
    }

    @Override
    public List<RecruitmentInformation> selectALLInformation() {
        return rInf.selectALLInformation();
    }

    @Override
    public List<RecruitmentInformation> selectInformation(int currentPage, int PAGESIZE) {
        return rInf.selectInformation(currentPage,PAGESIZE);
    }

    @Override
    public int updateByID(RecruitmentInformation recruitmentInformation) {
        return rInf.updateByID(recruitmentInformation);
    }
}
