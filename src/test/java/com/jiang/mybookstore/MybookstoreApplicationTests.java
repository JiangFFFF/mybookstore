package com.jiang.mybookstore;

import com.jiang.mybookstore.bean.User;
import com.jiang.mybookstore.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j //引入日志
@SpringBootTest
class MybookstoreApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
    }



    /**
     * 测试连接
     */
    @Test
    public void testConnect(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_user", Long.class);
        log.info("记录数为:{}",aLong);
    }


//    /**
//     * 测试登录
//     */
//    @Test
//    public void queryUserByUsernameAndPassword(){
//        User user = userMapper.queryByUsernameAndPassword("admin", "admin");
//        if(user!=null){
//            System.out.println("登录成功！");
//        }else{
//            System.out.println("登录失败！");
//        }
//    }

}
