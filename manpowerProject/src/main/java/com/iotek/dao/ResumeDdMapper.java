package com.iotek.dao;

import com.iotek.model.ResumeDd;

import java.util.List;

public interface ResumeDdMapper {
    int deleteByID(ResumeDd resumeDd);
    int addResumeDd(ResumeDd resumeDd);
    List<ResumeDd> selectAllResumeDd();
    int updateByID(ResumeDd resumeDd);
}