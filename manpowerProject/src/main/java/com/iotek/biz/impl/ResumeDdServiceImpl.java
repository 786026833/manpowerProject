package com.iotek.biz.impl;

import com.iotek.biz.ResumeDdService;
import com.iotek.biz.ResumeService;
import com.iotek.dao.ResumeDdMapper;
import com.iotek.model.ResumeDd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/4/22.
 */
@Service
public class ResumeDdServiceImpl implements ResumeDdService{
@Autowired
    private ResumeDdMapper resumeDdMapper;
    @Override
    public int deleteByID(ResumeDd resumeDd) {
        return resumeDdMapper.deleteByID(resumeDd);
    }

    @Override
    public int addResumeDd(ResumeDd resumeDd) {
        return resumeDdMapper.addResumeDd(resumeDd);
    }

    @Override
    public List<ResumeDd> selectAllResumeDd() {
        return resumeDdMapper.selectAllResumeDd();
    }

    @Override
    public int updateByID(ResumeDd resumeDd) {
        return resumeDdMapper.updateByID(resumeDd);
    }
}
