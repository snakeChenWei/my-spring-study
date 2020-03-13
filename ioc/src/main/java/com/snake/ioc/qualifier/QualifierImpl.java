package com.snake.ioc.qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author com.snake
 * @date   2020/3/9 22:46
 */
@Repository
@Primary
public class QualifierImpl implements QualifierDao {

    public void printHello() {
        System.out.println("hello spring - 0");
    }
}
