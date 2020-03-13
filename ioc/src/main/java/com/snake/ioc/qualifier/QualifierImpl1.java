package com.snake.ioc.qualifier;

import org.springframework.stereotype.Repository;

/**
 * @author com.snake
 * @date   2020/3/9 22:46
 */
@Repository
public class QualifierImpl1 implements QualifierDao {

    public void printHello() {
        System.out.println("hello spring - 1");
    }
}
