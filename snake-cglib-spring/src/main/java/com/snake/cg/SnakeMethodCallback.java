package com.snake.cg;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author snake
 * @date 2020/3/29 22:59
 */
public class SnakeMethodCallback implements MethodInterceptor {

    /**
     * @param o           代理对象
     * @param method      目标对象方法
     * @param objects     参数
     * @param methodProxy 代理方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("------method------");
        return methodProxy.invokeSuper(o,objects);
    }
}
