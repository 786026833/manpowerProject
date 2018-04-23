package com.iotek.dao;

import com.iotek.model.Resume;

import java.util.List;

public interface ResumeMapper {
    int deleteResumeByID(Resume resume);
    int addResume(Resume resume);
    List<Resume> selectResume(Resume resume);
    Resume selectOneResume(Resume resume);
    int updateResumeByID(Resume resume);

}