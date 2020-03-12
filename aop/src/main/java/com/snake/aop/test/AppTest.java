package com.snake.aop.test;

import com.snake.aop.config.ApplicationConfig;
import com.snake.aop.service.SnakeService;
import com.snake.aop.service.SnakeServiceImpl;
import com.snake.aop.service.SnakeServiceImpl2;
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
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        SnakeServiceImpl snakeService0 = (SnakeServiceImpl) context.getBean("snakeServiceImpl");
        snakeService0.printStr("0");

        SnakeServiceImpl snakeService1 = (SnakeServiceImpl) context.getBean("snakeServiceImpl");
        snakeService1.printStr("1");
        System.out.println(snakeService0.hashCode()+"|||"+snakeService1.hashCode());
        System.out.println("----------------------------------------------------------------");
        SnakeServiceImpl2 snakeService2 = (SnakeServiceImpl2) context.getBean("snakeService2");
        snakeService2.printStr("2");
        SnakeServiceImpl2 snakeService3 = (SnakeServiceImpl2) context.getBean("snakeService2");
        snakeService3.printStr("3");
        System.out.println(snakeService2.hashCode()+"|||"+snakeService3.hashCode());
//        SnakeService snakeService = (SnakeService) context.getBean("emptySnakeService");
//        snakeService.printStr("niuBi");
//        snakeService.printStr("niuBi2");

        // 生成代理对象
//        Class<?>[] interfaces = {SnakeService.class};
//        byte[] bytes = ProxyGenerator.generateProxyClass("SnakeServices", interfaces);
//        File file = new File("./SnakeServices.class");
//        try {
//            FileOutputStream fileWriter = new FileOutputStream(file);
//            fileWriter.write(bytes);
//            fileWriter.flush();
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
