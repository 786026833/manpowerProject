package com.iotek.biz.impl;

import com.iotek.biz.CheckService;
import com.iotek.dao.CheckMapper;
import com.iotek.model.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
@Service
public class CheckServiceImpl implements CheckService{
    @Autowired
    private CheckMapper checkMapper;

    @Override
    public int deleteByID(Check check) {
        return checkMapper.deleteByID(check);
    }

    @Override
    public int addCheck(Check check) {
        return checkMapper.addCheck(check);
    }

    @Override
    public List<Check> selectAllCheck() {
        return checkMapper.selectAllCheck();
    }

    @Override
    public int updateByID(Check check) {
        return checkMapper.updateByID(check);
    }

    @Override
    public List<Check> selectAllCheckByEid(Check check) {
        return checkMapper.selectAllCheckByEid(check);
    }

    @Override
    public List<Check> select(Check check) {
        return checkMapper.select(check);
    }
}
