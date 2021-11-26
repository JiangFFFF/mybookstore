package com.jiang.mybookstore;

import com.jiang.mybookstore.bean.Cart;
import com.jiang.mybookstore.bean.CartItem;
import com.jiang.mybookstore.bean.Order;
import com.jiang.mybookstore.bean.OrderItem;
import com.jiang.mybookstore.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jiang
 * @create 2021-11-25-3:52 下午
 */
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    /**
     * 测试创建订单
     */
    @Test
    public void testcreateOrder(){
        Cart cart=new Cart();
        cart.add(new CartItem(1,"人间这出戏",1,new BigDecimal(22),new BigDecimal(22)));
        cart.add(new CartItem(2,"平凡的世界",1,new BigDecimal(133.1),new BigDecimal(133.1)));
        String order = orderService.createOrder(cart, 2);
        System.out.println("订单号为："+order);
    }

    /**
     * 测试serviceImpl中的我的订单查询
     */
    @Test
    public void ShowMyOrders(){
        List<Order> orders = orderService.showMyOrders(7);
        for(Order o:orders){
            System.out.println(o);
        }
    }


    /**
     * 测试查询订单详情
     */
    @Test
    public void testShowOrderDetail(){
        List<OrderItem> orderItems = orderService.showOrderDetail("16378289438572");
        orderItems.forEach(System.out::println);
    }

    /**
     * 用户确认收货
     */
    @Test
    public void testReceiveOrder(){
        orderService.receiveOrder("16378272543102");
    }

    /**
     * 管理员查询所有订单
     */
    @Test
    public void testShowAllOrders(){
        List<Order> orders = orderService.showAllOrders();
        for(Order o:orders){
            System.out.println(o);
            System.out.println("用户名为："+o.getUser().getUsername());
        }
    }



}
