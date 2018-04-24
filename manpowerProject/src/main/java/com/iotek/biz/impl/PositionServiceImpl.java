package com.iotek.biz.impl;

import com.iotek.biz.PositionService;
import com.iotek.dao.PositionMapper;
import com.iotek.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
@Service
public class PositionServiceImpl implements PositionService{
@Autowired
    private PositionMapper positionMapper;

    @Override
    public int deleteByID(Position position) {
        return positionMapper.deleteByID(position);
    }

    @Override
    public int addPosition(Position position) {
        return positionMapper.addPosition(position);
    }

    @Override
    public List<Position> selectAllPosition() {
        return positionMapper.selectAllPosition();
    }

    @Override
    public int updateByID(Position position) {
        return positionMapper.updateByID(position);
    }
}
