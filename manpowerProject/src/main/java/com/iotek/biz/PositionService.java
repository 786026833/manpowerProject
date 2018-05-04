package com.iotek.biz;

import com.iotek.model.Position;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
public interface PositionService {
    int deleteByID(Position position);
    int addPosition(Position position);
    List<Position> selectAllPosition();
    int updateByID(Position position);
    Position selectByID(Position position);
    Position selectByID1(Position position);
}
