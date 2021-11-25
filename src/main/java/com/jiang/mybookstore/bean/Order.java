package com.jiang.mybookstore.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 * @author jiang
 * @create 2021-11-25-3:01 下午
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    private String orderId;
    private Date createTime;
    private BigDecimal price;
    private Integer status=0;//0未发货，1已发货，2已签收
    private Integer userId;
}
