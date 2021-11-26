package com.jiang.mybookstore.mapper;

import com.jiang.mybookstore.bean.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jiang
 * @create 2021-11-25-3:15 下午
 */
@Mapper
public interface OrderItemMapper {
    /**
     * 保存订单项
     * @param orderItem
     * @return
     */
    public int saveOrderItem(OrderItem orderItem);

    /**
     * 根据订单号查询订单详情
     * @param orderId
     * @return
     */
    public List<OrderItem> showOrderDetail(String orderId);
}
