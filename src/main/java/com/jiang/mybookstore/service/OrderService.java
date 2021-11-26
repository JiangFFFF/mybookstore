package com.jiang.mybookstore.service;

import com.jiang.mybookstore.bean.Cart;
import com.jiang.mybookstore.bean.Order;
import com.jiang.mybookstore.bean.OrderItem;

import java.util.List;

/**
 * @author jiang
 * @create 2021-11-25-3:32 下午
 */
public interface OrderService {
    /**
     * 创建订单
     * @param cart
     * @param userId
     * @return
     */
    public String createOrder(Cart cart,Integer userId);

    /**
     * 查询我的订单
     * @param userId
     * @return
     */
    public List<Order> showMyOrders(Integer userId);

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    public List<OrderItem> showOrderDetail(String orderId);

    /**
     * 用户修改订单状态
     * @param orderId
     */
    public void receiveOrder(String orderId);

    /**
     * 查询所有订单信息
     * @return
     */
    public List<Order> showAllOrders();

    /**
     * 管理员更改订单状态
     * @param orderId
     */
    public void sendOrder(String orderId);
}
