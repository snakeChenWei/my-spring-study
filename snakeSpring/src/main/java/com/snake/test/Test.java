package com.snake.test;

import com.snake.service.UserService;
import com.snake.util.AnnotationConfigApplicationContext;
import com.snake.util.BeanFactory;

public class Test {
    public static void main(String[] args) {

        // 模拟spring 实例化对象.
//        BeanFactory beanFactory = new BeanFactory("spring.xml");
//        UserService service = (UserService) beanFactory.getBean("service");
//        service.find();

        // 模拟spring 扫描包
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.snake");
    }
}
