package com.jiang.mybookstore.mapper;

import com.jiang.mybookstore.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author jiang
 * @create 2021-11-16-11:30 下午
 */

@Mapper
public interface UserMapper {

    public User queryByUsernameAndPassword(User user);

}
