package com.snake.proxy;

import com.snake.proxy.service.SnakeService;
import com.snake.proxy.service.SnakeServiceImpl;
import com.snake.proxy.util.MyProxy;

/**
 * @auther: snake
 * @date: 2020/3/12 22:36
 */
public class Main {
    public static void main(String[] args) {
        SnakeService snakeService = (SnakeService) MyProxy.newInstance(new SnakeServiceImpl());
        snakeService.printStr();
        snakeService.sayName("陈","威");
    }
}
