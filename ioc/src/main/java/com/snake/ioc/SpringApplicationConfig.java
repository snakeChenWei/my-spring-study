package com.snake.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @auther: com.snake
 * @date: 2020/3/9 22:45
 */
//@Configuration // 3.通过javaConfig加载
@ComponentScan("com.snake.ioc")
//@ImportResource("classpath:spring.xml")// 用于读取xml
public class SpringApplicationConfig {
    public static void main(String[] args) {
        // 1.通过xml加载
//         ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        // 2.通过注解加载
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringApplicationConfig.class);
        SnakeService serviceImpl1 = (SnakeService) applicationContext.getBean("snakeService");
        SnakeService serviceImpl2 = (SnakeService) applicationContext.getBean("snakeService");
        serviceImpl1.printHello();
        serviceImpl2.printHello();
    }
}
