package com.jiang.mybookstore.mapper;

import com.jiang.mybookstore.bean.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jiang
 * @create 2021-11-25-3:08 下午
 */
@Mapper
public interface OrderMapper {
    public int saveOrder(Order order);
}
