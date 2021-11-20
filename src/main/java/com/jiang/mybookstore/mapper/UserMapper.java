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

    /**
     * 根据用户名和密码查询用户信息
     * @param user
     * @return
     */
    public User queryByUsernameAndPassword(User user);

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User queryUserByUsername(String username);

    /**
     * 保存用户信息
     * @param user
     * @return 返回-1表示操作失败
     */
    public int saveUser(User user);

}
