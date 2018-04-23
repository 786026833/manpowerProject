package com.iotek.biz;

import com.iotek.model.User;

/**
 * Created by Administrator on 2018/4/20.
 */
public interface UserService {
    int deleteByID(User user);
    int addUser(User user);
    User selectByName(User user);
    User selectByNamePass(User user);
    int updateByID(User record);
    User selectByID(User user);
}
