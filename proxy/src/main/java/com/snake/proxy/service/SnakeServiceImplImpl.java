package com.snake.proxy.service;

/**
 * @auther: snake
 * @date: 2020/3/12 22:36
 */
public class SnakeServiceImplImpl {

    private SnakeService snakeService;

    public SnakeServiceImplImpl(SnakeService snakeService) {
        this.snakeService = snakeService;
    }

    public void printStr() {
        System.out.println("======我是proxy printStr =======");
        snakeService.printStr();
    }

    public String sayName(String first, String last) {
        System.out.println("======我是proxy sayName =======");
        return snakeService.sayName(first,last);
    }
}
