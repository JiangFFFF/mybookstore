package com.jiang.mybookstore.service.impl;

import com.jiang.mybookstore.bean.Manager;
import com.jiang.mybookstore.mapper.ManagerMapper;
import com.jiang.mybookstore.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiang
 * @create 2021-11-21-2:08 下午
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerMapper managerMapper;

    /**
     * 管理员登录
     * @param manager
     * @return
     */
    @Override
    public Manager login(Manager manager) {
        return managerMapper.queryByManagernameAndPassword(manager);
    }
}
