package com.iotek.biz;

import com.iotek.model.Train;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
public interface TrainService {
    int deleteByID(Train train);
    int addTrain(Train train);
    List<Train> selectByAllTrain();
    int updateByID(Train train);
    List<Train> selectByeDid(Train train);
}
