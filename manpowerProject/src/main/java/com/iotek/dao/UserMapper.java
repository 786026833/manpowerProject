package com.iotek.dao;

import com.iotek.model.User;

public interface UserMapper {
    int deleteByID(User user);
    int addUser(User user);
    User selectByName(User user);
    User selectByNamePass(User user);
    User selectByID(User user);
    int updateByID(User user);
}