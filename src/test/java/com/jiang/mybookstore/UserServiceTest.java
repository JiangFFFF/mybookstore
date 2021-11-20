package com.jiang.mybookstore;

import com.jiang.mybookstore.bean.User;
import com.jiang.mybookstore.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author jiang
 * @create 2021-11-19-2:11 下午
 */
@Slf4j
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    /**
     * 测试用户名是否存在
     */
    @Test
    public void existsUsername(){
        if(userService.existsUsername("admin11")){
            System.out.println("用户名已存在！");
        }else{
            System.out.println("用户名可用！");
        }
    }

    /**
     * 测试用户保存
     */
    @Test
    public void saveUser(){
        userService.saveUser(new User(null,"xxx","123456","xxx@qq.com"));
    }

}
