package com.jiang.mybookstore;

import com.jiang.mybookstore.bean.Cart;
import com.jiang.mybookstore.bean.CartItem;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @author jiang
 * @create 2021-11-23-9:09 下午
 */
@SpringBootTest
public class CartTest {

    /**
     * 添加商品测试
     */
    @Test
    public void addItem(){
        Cart cart=new Cart();
        cart.add(new CartItem(1,"java",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.add(new CartItem(2,"c#",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.add(new CartItem(3,"c++",1,new BigDecimal(100),new BigDecimal(100)));
        System.out.println(cart);
    }

    /**
     * 测试商品删除
     */
    @Test
    public void deleteItem(){
        Cart cart=new Cart();
        cart.add(new CartItem(1,"java",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.add(new CartItem(2,"c#",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.add(new CartItem(3,"c++",1,new BigDecimal(100),new BigDecimal(100)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    /**
     * 测试购物车清空
     */
    @Test
    public void clear(){
        Cart cart=new Cart();
        cart.add(new CartItem(1,"java",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.add(new CartItem(2,"c#",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.add(new CartItem(3,"c++",1,new BigDecimal(100),new BigDecimal(100)));
        cart.clear();
        System.out.println(cart);
    }


    @Test
    public void updateCount(){
        Cart cart=new Cart();
        cart.add(new CartItem(1,"java",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.add(new CartItem(2,"c#",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.add(new CartItem(3,"c++",1,new BigDecimal(100),new BigDecimal(100)));

        cart.updateCount(1,10);
        System.out.println(cart);
    }


}
