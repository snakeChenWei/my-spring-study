package com.snake.test;

import com.snake.service.UserService;
import com.snake.util.BeanFactory;

public class Test {
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory("spring.xml");

        UserService service = (UserService) beanFactory.getBean("service");
//
        service.find();
    }
}
