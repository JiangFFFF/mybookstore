package com.jiang.mybookstore.controller;

import com.jiang.mybookstore.bean.*;
import com.jiang.mybookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author jiang
 * @create 2021-11-25-4:16 下午
 */
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * 创建订单
     * @param session
     * @return
     */
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


    /**
     * 去往我的订单页面
     * @return
     */
    @RequestMapping("/myOrderPage")
    public String myOrderPage(HttpSession session, Model model){
        User loginUser = (User) session.getAttribute("loginUser");
        List<Order> myorders = orderService.showMyOrders(loginUser.getId());
        model.addAttribute("myorders",myorders);
        return "order/order";
    }

    /**
     * 跳转订单详情页面
     * @return
     */
    @RequestMapping("/orderDetailPage")
    public String orderDetailPage(@RequestParam("orderId")String orderId,Model model){
        List<OrderItem> orderItems = orderService.showOrderDetail(orderId);
        model.addAttribute("orderItem",orderItems);
        for(OrderItem o:orderItems){
            model.addAttribute("orderId",o.getOrderId());
        }
        return "order/orderDetail";
    }

    /**
     * 用户确认收货
     * @param orderId
     * @param model
     * @return
     */
    @RequestMapping("/receiveOrder")
    @ResponseBody
    public Msg receiveOrder(@RequestParam("orderId")String orderId, Model model){
        orderService.receiveOrder(orderId);
        return Msg.success();
    }

    /**
     * 管理员查询所有订单
     * @return
     */
    @RequestMapping("/showAllOrdersPage")
    public String showAllOrdersPage(Model model){
        List<Order> allOrders = orderService.showAllOrders();
        model.addAttribute("allOrders",allOrders);
        return "order/showOrders";
    }


    @RequestMapping("/sendOrder")
    @ResponseBody
    public Msg sendOrder(@RequestParam("orderId")String orderId){
        orderService.sendOrder(orderId);
        return Msg.success();
    }



}
