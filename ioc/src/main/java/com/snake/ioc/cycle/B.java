package com.snake.ioc.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author snake
 * @date   2020/3/11 00:36
 */
@Component
// 多例循环引用会报错, 单例不影响
public class B {
    @Autowired
    private A a;

    public B() {
        System.out.println("---------init B init B init B init B-----");
    }
}
