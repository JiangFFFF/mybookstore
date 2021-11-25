package com.jiang.mybookstore.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 购物车的商品项
 * @author jiang
 * @create 2021-11-23-5:36 下午
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartItem {
    private Integer id;
    private String name;
    private Integer count;
    private BigDecimal price;
    private BigDecimal totalPrice;


}
