package com.jiang.mybookstore;

import com.jiang.mybookstore.bean.Order;
import com.jiang.mybookstore.bean.OrderItem;
import com.jiang.mybookstore.mapper.OrderItemMapper;
import com.jiang.mybookstore.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author jiang
 * @create 2021-11-25-3:22 下午
 */
@SpringBootTest
public class OrderMapperAndOrderItemMapperTest {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    /**
     * 测试订单保存
     */
    @Test
    public void testSaveOrder(){
        orderMapper.saveOrder(new Order("123456789",new Date(),new BigDecimal(100),0,1));
    }

    /**
     * 测试保存订单项
     */
    @Test
    public void testSaveOrderItem(){
        orderItemMapper.saveOrderItem(new OrderItem(null,"人间这出戏",1,new BigDecimal(22),new BigDecimal(22),"123456789"));
        orderItemMapper.saveOrderItem(new OrderItem(null,"飞鸟集",2,new BigDecimal(19),new BigDecimal(38),"123456789"));
    }

    /**
     * 测试查看我的订单
     */
    @Test
    public void testShowMyOrders(){
        List<Order> orders = orderMapper.showMyOrders(7);
        for(Order order:orders){
            System.out.println(order);
        }
    }

    @Test
    public void testShowOrderDetail(){
        List<OrderItem> orderItems = orderItemMapper.showOrderDetail("16378272543102");
        for(OrderItem orderItem:orderItems) {
            System.out.println(orderItem);
        }
    }

    /**
     * 测试用户确认收货
     */
    @Test
    public void testReceiveOrder(){
        orderMapper.receiveOrder("16378292124317");
    }


    /**
     * Mapper
     * 查询所有订单
     */
    @Test
    public void testShowAllOrdersMapper(){
        List<Order> orders = orderMapper.showAllOrders();
        for(Order o:orders){
            System.out.println(o);
            System.out.println("用户名为:"+o.getUser().getUsername());
        }
    }







}
