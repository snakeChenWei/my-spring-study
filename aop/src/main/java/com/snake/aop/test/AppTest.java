package com.snake.aop.test;

import com.snake.aop.config.ApplicationConfig;
import com.snake.aop.service.SnakeService;
import javafx.application.Application;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author snake
 * on 2020/3/11 17:57.
 */
public class AppTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        SnakeService snakeService = (SnakeService) context.getBean("snakeService");
        snakeService.printStr("ssss");

    }
}
