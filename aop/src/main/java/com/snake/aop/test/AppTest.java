package com.snake.aop.test;

import com.snake.aop.config.ApplicationConfig;
import com.snake.aop.service.SnakeService;
import javafx.application.Application;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author snake
 * on 2020/3/11 17:57.
 */
public class AppTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        SnakeService snakeService = context.getBean(SnakeService.class);
        snakeService.printStr("1");
        snakeService.printStr("1","2");


        // 生成代理对象
        Class<?>[] interfaces = {SnakeService.class};
        byte[] bytes = ProxyGenerator.generateProxyClass("SnakeServices", interfaces);
        File file = new File("./SnakeServices.class");
        try {
            FileOutputStream fileWriter = new FileOutputStream(file);
            fileWriter.write(bytes);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
