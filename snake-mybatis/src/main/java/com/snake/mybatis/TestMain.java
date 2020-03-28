package com.snake.mybatis;

import com.snake.mybatis.service.SnakeDao;
import com.snake.mybatis.service.SnakeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author snake
 * @date 2020/3/28 16:06.
 */
public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
//        annotationConfigApplicationContext.register(SnakeService.class);
//        annotationConfigApplicationContext.getBean(SnakeService.class).printStr();
        ((SnakeDao)annotationConfigApplicationContext.getBean("snakeDao")).SelectUser();
//        ((SnakeService)annotationConfigApplicationContext.getBean("snakeService")).select();
    }
}
