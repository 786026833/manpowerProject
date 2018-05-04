package com.iotek.dao;

import com.iotek.model.Check;

import java.util.Date;
import java.util.List;

public interface CheckMapper {
    int deleteByID(Check check);
    int addCheck(Check check);
    List<Check> selectAllCheck();
    int updateByID(Check check);
    List<Check> selectAllCheckByEid(Check check);
    List<Check> select(Check check);
}