package com.snake.cg;

import com.snake.cg.dao.SnakeDao1;
import com.snake.cg.dao.SnakeDao2;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.ConfigurationClassEnhancer;

/**
 * @auther: snake
 * @date: 2020/3/29 22:45
 */
public class TestMain {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(SnakeDao2.class);


        Enhancer enhancer = new Enhancer();
        // 增强父类,基于继承来的
        enhancer.setSuperclass(SnakeDao1.class);
        enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
          // 过滤方法,不能每次都去new
        enhancer.setCallback(new SnakeMethodCallback());

        SnakeDao1 snakeDao1 = (SnakeDao1) enhancer.create();
        snakeDao1.printStr();

    }
}
