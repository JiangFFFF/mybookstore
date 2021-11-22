package com.jiang.mybookstore.controller;

import com.jiang.mybookstore.bean.Manager;
import com.jiang.mybookstore.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author jiang
 * @create 2021-11-21-11:50 上午
 */
@Controller
public class ManagerController {
    @Autowired
    ManagerService managerService;

    /**
     * 去往管理员登录界面
     * @return
     */
    @GetMapping("/managerLogin")
    public String managerLoginPage(){
        return "manager/manager_login";
    }

    /**
     * 跳转后台管理页面
     * @return
     */
    @GetMapping("/manager")
    public String managerPage(){
        return "manager/manager";
    }


    @PostMapping("/manager/login")
    public String managerLogin(Manager manager, Model model, HttpSession session){
        Manager loginManager = managerService.login(manager);
        if(loginManager!=null){
            session.setAttribute("loginManager",loginManager);
            return "redirect:/manager";
        }else{
            model.addAttribute("msg","账号密码错误");
            model.addAttribute("managername",manager.getManagerName());
            return "manager/manager_login";
        }
    }

}
