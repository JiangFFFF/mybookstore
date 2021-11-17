package com.jiang.mybookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jiang
 * @create 2021-11-16-9:55 下午
 */
@Controller
public class IndexController {

    /**
     * 首页
     * @return
     */
    @GetMapping(value={"/","/index"})
    public String indexPage(){
        return "index";
    }

    /**
     * 跳转登录界面
     * @return
     */
    @GetMapping("/login")
    public String loginPage(){
        return "user/login";
    }

}
