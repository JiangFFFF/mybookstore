package com.jiang.mybookstore.mapper;

import com.jiang.mybookstore.bean.Manager;
import com.jiang.mybookstore.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jiang
 * @create 2021-11-21-12:03 下午
 */

@Mapper
public interface ManagerMapper {

    /**
     * 判断管理员账号与密码
     * @param manager
     * @return
     */
    public Manager queryByManagernameAndPassword(Manager manager);
}
