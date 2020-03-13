package com.snake.ioc;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @author com.snake
 * @date   2020/3/9 22:46
 */
@Repository("snakeDao")
@Scope("prototype")
public class SnakeDaoImpl implements SnakeDao {

    public void printHello() {
        System.out.println("hello spring - 0");
    }
}
