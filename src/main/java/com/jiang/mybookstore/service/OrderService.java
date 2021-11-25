package com.jiang.mybookstore.service;

import com.jiang.mybookstore.bean.Cart;

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
}
