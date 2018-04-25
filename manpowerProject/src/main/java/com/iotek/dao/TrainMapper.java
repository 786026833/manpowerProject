package com.iotek.dao;

import com.iotek.model.Train;

import java.util.List;

public interface TrainMapper {
    int deleteByID(Train train);
    int addTrain(Train train);
    List<Train> selectByAllTrain();
    int updateByID(Train train);

}