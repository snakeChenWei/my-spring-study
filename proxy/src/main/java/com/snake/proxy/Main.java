package com.snake.proxy;

import com.snake.proxy.service.SnakeService;
import com.snake.proxy.service.SnakeServiceImpl;
import com.snake.proxy.util.MyInvocationHandlerImpl;
import com.snake.proxy.util.MyProxy;
import com.snake.proxy.util.MyProxy2;
import com.snake.proxy.util.SnakeInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @author snake
 * @date 2020/3/12 22:36
 */
public class Main {
    public static void main(String[] args) {
//        SnakeService snakeService = (SnakeService) MyProxy.newInstance(new SnakeServiceImpl());
//        snakeService.printStr();
//        snakeService.sayName("陈", "威");

        SnakeService snakeService = (SnakeService) MyProxy2.newInstance(
                SnakeService.class
                , new MyInvocationHandlerImpl(new SnakeServiceImpl())
        );
        snakeService.printStr();
        snakeService.sayName("陈", "威");


//        SnakeService snakeServiceProxy = (SnakeService) Proxy.newProxyInstance(
//                 Main.class.getClassLoader()
//                , new Class[]{SnakeService.class}
//                ,new SnakeInvocationHandler(new SnakeServiceImpl()));
//        snakeServiceProxy.printStr();
    }
}
