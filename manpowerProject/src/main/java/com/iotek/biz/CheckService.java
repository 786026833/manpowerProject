package com.iotek.biz;

import com.iotek.model.Check;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
public interface CheckService {
    int deleteByID(Check check);
    int addCheck(Check check);
    List<Check> selectAllCheck();
    int updateByID(Check check);
}
