package com.jiang.mybookstore.controller;

import com.jiang.mybookstore.bean.Cart;
import com.jiang.mybookstore.bean.User;
import com.jiang.mybookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author jiang
 * @create 2021-11-25-4:16 下午
 */
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/createOrder")
    public String createOrder(HttpSession session){
        //先获取Cart购物车对象
        Cart cart = (Cart) session.getAttribute("cart");
        //获取登录的用户信息
        User loginUser = (User) session.getAttribute("loginUser");
        if(loginUser==null){
            return "user/login";
        }
        //获取登录成功用户的id
        Integer userId = loginUser.getId();
        //生成订单
        String orderId = orderService.createOrder(cart, userId);
        session.setAttribute("orderId",orderId);
        return "redirect:/checkoutPage";
    }


    /**
     * 去往结算页面
     * @return
     */
    @RequestMapping("/checkoutPage")
    public String checkoutPage(){
        return "cart/checkout";
    }

}
