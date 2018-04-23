package com.iotek.biz.impl;

import com.iotek.biz.ResumeService;
import com.iotek.dao.ResumeMapper;
import com.iotek.model.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/4/21.
 */
@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeMapper resumeMapper;
    @Override
    public int deleteResumeByID(Resume resume) {
        return resumeMapper.deleteResumeByID(resume);
    }

    @Override
    public int addResume(Resume resume) {
        return resumeMapper.addResume(resume);
    }

    @Override
    public List<Resume> selectResume(Resume resume) {
        return resumeMapper.selectResume(resume);
    }


    @Override
    public int updateResumeByID(Resume resume) {
        return resumeMapper.updateResumeByID(resume);
    }
    @Override
    public Resume selectOneResume(Resume resume) {
        return resumeMapper.selectOneResume(resume);
    }
}
