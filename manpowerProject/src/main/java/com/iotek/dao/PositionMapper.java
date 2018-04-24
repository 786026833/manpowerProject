package com.iotek.dao;

import com.iotek.model.Position;

import java.util.List;

public interface PositionMapper {
    int deleteByID(Position position);
    int addPosition(Position position);
    List<Position> selectAllPosition();
    int updateByID(Position position);
}