package com.iotek.biz;

import com.iotek.model.Resume;

import java.util.List;

/**
 * Created by Administrator on 2018/4/21.
 */
public interface ResumeService {
    int deleteResumeByID(Resume resume);
    int addResume(Resume resume);
    List<Resume> selectResume(Resume resume);
    int updateResumeByID(Resume resume);
}
