package com.jiang.mybookstore.mapper;

import com.jiang.mybookstore.bean.OrderItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jiang
 * @create 2021-11-25-3:15 下午
 */
@Mapper
public interface OrderItemMapper {
    public int saveOrderItem(OrderItem orderItem);
}
