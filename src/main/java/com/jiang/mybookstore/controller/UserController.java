package com.jiang.mybookstore.controller;

import com.jiang.mybookstore.bean.User;
import com.jiang.mybookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

/**
 * @author jiang
 * @create 2021-11-17-12:15 上午
 */

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(User user,String password, Model model, HttpSession session){
        User login = userService.login(new User(null,user.getUserName(),user.getPassWord(),null));
        if(login!=null){
            return "user/login_success";
        }else{
            return "user/login";
        }
    }



}
