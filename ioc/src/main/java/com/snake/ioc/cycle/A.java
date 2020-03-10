package com.snake.ioc.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @auther: snake
 * @date: 2020/3/11 00:36
 */
@Component
// 多例循环引用会报错, 单例不影响
public class A {
    @Autowired
    private B b;


    public A() {
        System.out.println("---------init A init A init A init A-----");
    }
}
