package com.iotek.biz;

import com.iotek.model.RewardPunishment;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */

public interface RewardPunishmentService {
    int deleteByID(RewardPunishment rewardPunishment);
    int addRewardPunishment(RewardPunishment rewardPunishment);

    RewardPunishment selectByID(RewardPunishment rewardPunishment);
    List<RewardPunishment> selectAllRewardPunishment();
    int updateByID(RewardPunishment rewardPunishment);
}
