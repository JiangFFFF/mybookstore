package com.jiang.mybookstore.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jiang
 * @create 2021-11-21-11:56 上午
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Manager {
    private Integer id;
    private String managerName;
    private String password;
}
