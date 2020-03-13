package com.snake.ioc;

import org.springframework.stereotype.Repository;

/**
 * @author com.snake
 * @date   2020/3/9 22:46
 */
@Repository("snakeDao1")
public class SnakeDaoImpl1 implements SnakeDao {

    public void printHello() {
        System.out.println("hello spring - 1");
    }
}
