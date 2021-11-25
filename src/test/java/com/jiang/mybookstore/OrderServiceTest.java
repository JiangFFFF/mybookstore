package com.jiang.mybookstore;

import com.jiang.mybookstore.bean.Cart;
import com.jiang.mybookstore.bean.CartItem;
import com.jiang.mybookstore.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @author jiang
 * @create 2021-11-25-3:52 下午
 */
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    public void testcreateOrder(){
        Cart cart=new Cart();
        cart.add(new CartItem(1,"人间这出戏",1,new BigDecimal(22),new BigDecimal(22)));
        cart.add(new CartItem(2,"平凡的世界",1,new BigDecimal(133.1),new BigDecimal(133.1)));
        String order = orderService.createOrder(cart, 2);
        System.out.println("订单号为："+order);
    }

}
