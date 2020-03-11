package com.snake.aop.entity;

import com.snake.aop.anno.Table;

/**
 * @author snake
 * on 2020/3/10 17:31.
 */
@Table(key = "李明", value = "牛逼")
public class Student {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
