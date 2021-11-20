package com.jiang.mybookstore;

import com.jiang.mybookstore.bean.User;
import com.jiang.mybookstore.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author jiang
 * @create 2021-11-19-2:08 下午
 */
@Slf4j //引入日志
@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;


    /**
     * 测试登录
     */
    @Test
    public void queryUserByUsernameAndPassword(){
        User user = userMapper.queryByUsernameAndPassword(new User(null,"admin", "admin",null));
        if(user!=null){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }
    }

    /**
     * 测试根据用户名查询用户信息
     */
    @Test
    public void queryUserByName(){
        if(userMapper.queryUserByUsername("admin")==null){
            System.out.println("用户名可用");
        }else{
            System.out.println("用户名已存在!");
        }
    }

    /**
     * 测试保存用户
     */
    @Test
    public void saveUser(){
        System.out.println(userMapper.saveUser(new User(null, "kkk", "123456", "kkk@qq.com")));
    }
}
