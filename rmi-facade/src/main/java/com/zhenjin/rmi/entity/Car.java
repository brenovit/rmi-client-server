package com.zhenjin.rmi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户信息
 * 对于对象必须实现Serializable接口
 *
 * @author ZhenJin
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户姓名
     **/
    private String model;

    /**
     * 用户性别
     **/
    private String color;

    /**
     * 用户年龄
     **/
    private Integer year;


}
