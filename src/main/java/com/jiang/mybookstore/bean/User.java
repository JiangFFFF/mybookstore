package com.jiang.mybookstore.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jiang
 * @create 2021-11-16-10:23 下午
 */
@Data //相当于getter、setter、toString方法
@AllArgsConstructor //有参构造器
@NoArgsConstructor //空参构造器
public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String email;

}
