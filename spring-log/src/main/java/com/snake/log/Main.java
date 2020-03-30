package com.snake.log;

import org.apache.commons.logging.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author snake
 * @date 2020/3/30 19:41.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(Snake.class);
        annotationConfigApplicationContext.refresh();
        annotationConfigApplicationContext.start();
    }
}
