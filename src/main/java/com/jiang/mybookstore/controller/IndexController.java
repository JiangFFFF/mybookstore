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
     * 跳转登录页面
     * @return
     */
    @GetMapping("/login")
    public String loginPage(){
        return "user/login";
    }

    /**
     * 跳转注册页面
     * @return
     */
    @GetMapping("/regist")
    public String registPage(){
        return "user/regist";
    }

    /**
     * 跳转购物车页面
     * @return
     */
    @GetMapping("/cart")
    public String cartPage(){
        return "cart/cart";
    }



    /**
     * 跳转我的订单页面
     * @return
     */
    @GetMapping("/order")
    public String orderPage(){
        return "order/order";
    }



}
