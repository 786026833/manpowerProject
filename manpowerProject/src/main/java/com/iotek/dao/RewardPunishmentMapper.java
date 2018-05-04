package com.iotek.dao;

import com.iotek.model.RewardPunishment;

import java.util.List;

public interface RewardPunishmentMapper {
    int deleteByID(RewardPunishment rewardPunishment);
    int addRewardPunishment(RewardPunishment rewardPunishment);

    RewardPunishment selectByID(RewardPunishment rewardPunishment);
    List<RewardPunishment> selectAllRewardPunishment();
    int updateByID(RewardPunishment rewardPunishment);
    List<RewardPunishment> selectByEid(RewardPunishment rewardPunishment);
    List<RewardPunishment> select(String month,long eId);
}