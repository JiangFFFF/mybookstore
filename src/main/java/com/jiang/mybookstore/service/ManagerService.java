package com.jiang.mybookstore.service;

import com.jiang.mybookstore.bean.Manager;
import com.jiang.mybookstore.bean.User;

/**
 * @author jiang
 * @create 2021-11-21-2:06 下午
 */
public interface ManagerService {

    /**
     * 管理员登录
     * @param manager
     * @return
     */
    public Manager login(Manager manager);
}
