package com.snake.proxy.util;

import java.lang.reflect.Method;

/**
 * @auther: snake
 * @date: 2020/3/13 21:36
 */
public interface MyInvocationHandler {

    Object invoke(Method method, Object... args);
}
