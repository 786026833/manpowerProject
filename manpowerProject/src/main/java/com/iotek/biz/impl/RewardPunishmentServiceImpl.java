package com.iotek.biz.impl;

import com.iotek.biz.RecruitmentInformationService;
import com.iotek.biz.RewardPunishmentService;
import com.iotek.dao.RewardPunishmentMapper;
import com.iotek.model.RewardPunishment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */
@Service
public class RewardPunishmentServiceImpl implements RewardPunishmentService{
    @Autowired
    private RewardPunishmentMapper rewardPunishmentMapper;
    @Override
    public int deleteByID(RewardPunishment rewardPunishment) {
        return rewardPunishmentMapper.deleteByID(rewardPunishment);
    }

    @Override
    public int addRewardPunishment(RewardPunishment rewardPunishment) {
        return rewardPunishmentMapper.addRewardPunishment(rewardPunishment);
    }

    @Override
    public RewardPunishment selectByID(RewardPunishment rewardPunishment) {
        return rewardPunishmentMapper.selectByID(rewardPunishment);
    }

    @Override
    public List<RewardPunishment> selectAllRewardPunishment() {
        return rewardPunishmentMapper.selectAllRewardPunishment();
    }

    @Override
    public int updateByID(RewardPunishment rewardPunishment) {
        return rewardPunishmentMapper.updateByID(rewardPunishment);
    }
}
