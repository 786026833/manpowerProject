package com.iotek.dao;

import com.iotek.model.RecruitmentInformation;

import java.util.List;

/**
 * Created by Administrator on 2018/4/21.
 */
public interface RecruitmentInformationMapper {
    int deleteByID(RecruitmentInformation recruitmentInformation);//删除招聘信息
    int addRecruitmentInformation (RecruitmentInformation recruitmentInformation);//添加招聘信息
    RecruitmentInformation selectByID(RecruitmentInformation recruitmentInformation);//查询单个招聘信息
    List<RecruitmentInformation> selectALLInformation();//查询所有招聘信息的个数
    List<RecruitmentInformation> selectInformation(int currentPage, int PAGESIZE);//分页查询所有招聘信息的个数
    int updateByID(RecruitmentInformation recruitmentInformation);//删除招聘信息
}
