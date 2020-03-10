package com.snake.ioc.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @auther: snake
 * @date: 2020/3/11 00:36
 */
// 多例循环引用会报错, 单例不影响
@Component
@Scope("prototype")
public class D {
    @Autowired
    private C c;

    public D() {
        System.out.println("---------init D init D init D-----");
    }
}
