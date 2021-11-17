package com.jiang.mybookstore.service.impl;

import com.jiang.mybookstore.bean.User;
import com.jiang.mybookstore.mapper.UserMapper;
import com.jiang.mybookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiang
 * @create 2021-11-17-12:12 上午
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.queryByUsernameAndPassword(new User(null,user.getUserName(),user.getPassWord(),null));
    }
}
