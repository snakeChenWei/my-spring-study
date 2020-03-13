package com.snake.proxy.service;

/**
 * @author snake
 * @date   2020/3/12 22:36
 */
public class SnakeServiceImpl implements SnakeService {

    @Override
    public void printStr() {
        System.out.println("======snakeServiceImpl printStr=======");
    }

    @Override
    public String sayName(String first, String last) {
        System.out.println("======snakeServiceImpl sayName=======" + first + " " + last);
        return first + last;
    }
}
