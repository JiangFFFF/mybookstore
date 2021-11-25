package com.jiang.mybookstore.service.impl;

import com.jiang.mybookstore.bean.*;
import com.jiang.mybookstore.mapper.BookMapper;
import com.jiang.mybookstore.mapper.OrderItemMapper;
import com.jiang.mybookstore.mapper.OrderMapper;
import com.jiang.mybookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author jiang
 * @create 2021-11-25-3:33 下午
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    BookMapper bookMapper;

    /**
     * 根据用户id和购物车创建订单
     * @param cart
     * @param userId
     * @return
     */
    @Override
    public String createOrder(Cart cart, Integer userId) {
        //订单号-唯一性
        String orderId=System.currentTimeMillis()+""+userId;
        //创建订单对象
        Order order=new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        //保存订单
        orderMapper.saveOrder(order);

        //遍历购物车中每一个商品项转换成为订单项保存到数据库
        if(cart.getItems()!=null){
            for(Map.Entry<Integer, CartItem>entry:cart.getItems().entrySet()){
                //获取每一个购物车的商品项
                CartItem cartItem = entry.getValue();
                //转换为每一个订单项
                OrderItem orderItem=new OrderItem(null,cartItem.getName(),cartItem.getCount(),
                        cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
                //保存订单项到数据库
                orderItemMapper.saveOrderItem(orderItem);

                //更新库存和销量
                Book book = bookMapper.queryBookById(cartItem.getId());
                book.setSales(book.getSales()+cartItem.getCount());
                book.setStock(book.getStock()-cartItem.getCount());
                bookMapper.updateBook(book);

            }
        }
        //清空购物车
        cart.clear();
        return orderId;
    }
}
