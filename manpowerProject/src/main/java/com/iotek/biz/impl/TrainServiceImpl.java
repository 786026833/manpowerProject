package com.iotek.biz.impl;

import com.iotek.biz.TrainService;
import com.iotek.dao.TrainMapper;
import com.iotek.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
@Service
public class TrainServiceImpl implements TrainService {
    @Autowired
    private TrainMapper trainMapper;

    @Override
    public int deleteByID(Train train) {
        return trainMapper.deleteByID(train);
    }

    @Override
    public int addTrain(Train train) {
        return trainMapper.addTrain(train);
    }

    @Override
    public List<Train> selectByAllTrain() {
        return trainMapper.selectByAllTrain();
    }

    @Override
    public int updateByID(Train train) {
        return trainMapper.updateByID(train);
    }
}
