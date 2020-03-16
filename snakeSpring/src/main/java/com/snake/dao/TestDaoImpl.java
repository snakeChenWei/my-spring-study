package com.snake.dao;

import com.snake.annotation.Snake;

@Snake("testDao")
public class TestDaoImpl implements TestDao {
    @Override
    public void query() {
        System.out.println("test");
    }
}
