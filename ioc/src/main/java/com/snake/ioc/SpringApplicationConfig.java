package com.snake.ioc;

import com.snake.ioc.mybatis.DataSourceConfigWindows;
import org.springframework.context.annotation.*;

/**
 * @author com.snake
 * @date   2020/3/9 22:45
 */
@Configuration // 3.通过javaConfig加载
@ComponentScan(basePackages = "com.snake.ioc",
//        当2个单独的ComponentScans扫描同一个包时（如在测试中），这将不起作用。比如xml有自动扫描, 注解也有扫描.
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {ExcludeController.class})})
@ImportResource("classpath:spring.xml")// 用于读取xml
public class SpringApplicationConfig {
    public static void main(String[] args) {
        // 1.通过xml加载
//         ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        // 2.通过注解加载
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("mac");
        applicationContext.register(SpringApplicationConfig.class, DataSourceConfigWindows.class, DataSourceConfigWindows.class);
        applicationContext.refresh();
        SnakeService serviceImpl1 = (SnakeService) applicationContext.getBean("snakeService");
//        SnakeService serviceImpl2 = (SnakeService) applicationContext.getBean("snakeService");
        serviceImpl1.printHello();
//        serviceImpl2.printHello();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        LazyController lazyController = applicationContext.getBean(LazyController.class);
//        QualifierService qualifierService = applicationContext.getBean(QualifierService.class);
//        qualifierService.sayHello();

//        D d = applicationContext.getBean(D.class);
    }
}
