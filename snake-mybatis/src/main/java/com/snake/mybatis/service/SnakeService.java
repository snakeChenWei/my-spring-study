package com.snake.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author snake
 * @date 2020/3/28 16:24.
 */
@Component
public class SnakeService {
    @Autowired
    SnakeDao snakeDao;

    public void select(){
        System.out.println("-----select-----");
    }
}
