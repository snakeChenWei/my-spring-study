package com.snake.is;

import com.snake.is.dao.SnakeDao1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @auther: snake
 * @date: 2020/3/29 12:23
 */
public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(SnakeDao1.class).print();
    }
}
