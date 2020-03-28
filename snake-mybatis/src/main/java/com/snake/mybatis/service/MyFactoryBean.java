package com.snake.mybatis.service;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author snake
 * @date 2020/3/28 16:15.
 */
public class MyFactoryBean implements FactoryBean, InvocationHandler {

    Class clazz;

    public MyFactoryBean(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object getObject() throws Exception {
        Object p = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, this);
        return p;
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy");
        Select s = proxy.getClass().getInterfaces()[0].getMethod("SelectUser").getAnnotation(Select.class);
        System.out.println(s.value()[0]);
        return null;
    }
}
