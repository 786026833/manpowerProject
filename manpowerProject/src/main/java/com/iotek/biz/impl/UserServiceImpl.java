package com.iotek.biz.impl;

import com.iotek.biz.UserService;
import com.iotek.dao.UserMapper;
import com.iotek.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/4/20.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int deleteByID(User user) {
        return userMapper.deleteByID(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User selectByName(User user) {
        return userMapper.selectByName(user);
    }

    @Override
    public User selectByNamePass(User user) {
        return userMapper.selectByNamePass(user);
    }

    @Override
    public int updateByID(User user) {
        return userMapper.deleteByID(user);
    }

    @Override
    public User selectByID(User user) {
        return userMapper.selectByID(user);
    }
}
