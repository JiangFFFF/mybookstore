package com.jiang.mybookstore.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author jiang
 * @create 2021-11-20-10:44 下午
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    private Integer id;
    private String name;
    private String author;
    private BigDecimal price;
    private Integer sales;
    private Integer stock;
    private String imgPath= "img/default.jpg";


}
