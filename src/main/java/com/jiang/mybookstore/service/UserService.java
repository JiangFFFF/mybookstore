package com.jiang.mybookstore.service;

import com.jiang.mybookstore.bean.User;

/**
 * @author jiang
 * @create 2021-11-17-12:11 上午
 */

public interface UserService {

    //登录
    public User login(User user);

    //检查用户名是否可用
    public boolean existsUsername(String username);

    //保存用户信息
    public void saveUser(User user);

}
