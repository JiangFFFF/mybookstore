package com.jiang.mybookstore.mapper;

import com.jiang.mybookstore.bean.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jiang
 * @create 2021-11-25-3:08 下午
 */
@Mapper
public interface OrderMapper {
    /**
     * 保存订单
     * @param order
     * @return
     */
    public int saveOrder(Order order);

    /**
     * 根据用户id查询订单
     * @param userId
     * @return
     */
    public List<Order> showMyOrders(Integer userId);

    /**
     * 用户确认收货
     * @param orderId
     */
    public void receiveOrder(String orderId);

    /**
     * 查询所有订单
     * @return
     */
    public List<Order> showAllOrders();

    /**
     * 管理员发货
     * @param orderId
     */
    public void sendOrder(String orderId);


}
