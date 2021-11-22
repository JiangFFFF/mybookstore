package com.jiang.mybookstore;

import com.jiang.mybookstore.bean.Manager;
import com.jiang.mybookstore.mapper.ManagerMapper;
import com.jiang.mybookstore.service.ManagerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author jiang
 * @create 2021-11-21-2:00 下午
 */
@SpringBootTest
public class ManagerMapperAndServiceTest {
    @Autowired
    ManagerMapper managerMapper;

    @Autowired
    ManagerService managerService;

    @Test
    public void testManagerMapperquery(){
        Manager admin = managerMapper.queryByManagernameAndPassword(new Manager(null, "admin", "123456"));
        System.out.println(admin);
    }


    @Test
    public void testManagerServicelogin(){
        Manager admin = managerService.login(new Manager(null, "admin", "123456"));
        System.out.println(admin);
    }

}
