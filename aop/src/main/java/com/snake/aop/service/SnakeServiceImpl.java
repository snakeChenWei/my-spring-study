package com.snake.aop.service;

import com.snake.aop.anno.Table;
import org.springframework.stereotype.Service;

/**
 * @auther: com.snake
 * @date: 2020/3/9 22:46
 */
@Service
@Table
public class SnakeServiceImpl implements SnakeService {

    public void printHello() {
        System.out.println("hello spring - 0");
    }

    public void printStr(@Table String s){
        System.out.println("-----s1-----");
    }

    @Table
    public void printStr(String s,String s2){
        System.out.println("-----s2-----");
    }
}
