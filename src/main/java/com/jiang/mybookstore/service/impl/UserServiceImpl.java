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

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userMapper.queryByUsernameAndPassword(new User(null,user.getUsername(),user.getPassword(),null));
    }

    /**
     * 检查用户名是否可用
     * @param userName
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    @Override
    public boolean existsUsername(String userName) {
        User user = userMapper.queryUserByUsername(userName);
        if(user==null){
            return false;
        }
        return true;
    }

    /**
     *  保存用户信息
     * @param user
     */
    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }
}
