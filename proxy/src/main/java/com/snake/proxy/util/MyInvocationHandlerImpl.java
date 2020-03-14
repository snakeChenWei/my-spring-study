package com.snake.proxy.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author  snake
 * @date    2020/3/13 21:38
 */
public class MyInvocationHandlerImpl implements MyInvocationHandler {

    private Object target;

    public MyInvocationHandlerImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Method method, Object... args) {
        try {
            String name = method.getName();
            if ("sayName".equals(name)){
                System.out.println("-------------my invoke----------------");

            }
            return method.invoke(target, args);// target必须是method所在的对象
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
