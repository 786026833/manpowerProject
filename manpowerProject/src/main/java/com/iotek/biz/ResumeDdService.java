package com.iotek.biz;

import com.iotek.model.ResumeDd;

import java.util.List;

/**
 * Created by Administrator on 2018/4/22.
 */
public interface ResumeDdService {
    int deleteByID(ResumeDd resumeDd);
    int addResumeDd(ResumeDd resumeDd);
    List<ResumeDd> selectAllResumeDd();
    int updateByID(ResumeDd resumeDd);
}
