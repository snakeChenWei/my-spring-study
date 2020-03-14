package com.snake.proxy.util;

import com.snake.proxy.service.SnakeService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @auther: snake
 * @date: 2020/3/13 20:16
 */
public class SnakeInvocationHandler implements InvocationHandler {
    private Object target;

    public SnakeInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy  代理对象
     * @param method 目标方法对象
     * @param args   目标方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        if ("sayName".equals(name)) {
            System.out.println("-------------jdk invoke----------------");

        }
        return method.invoke(target, args);
    }
}
