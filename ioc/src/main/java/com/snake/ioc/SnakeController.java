package com.snake.ioc;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @auther: com.snake
 * @date: 2020/3/9 22:44
 */
// 声明周期和回调
// 方式1.实现InitializingBean接口,重写afterPropertiesSet(),
    // 方式2. @PostConstruct + 方法
    // 方式3. xml <bean id="snakeController" class="com.snake.ioc.SnakeController" init-method="init3"/>
public class SnakeController implements InitializingBean {
    public SnakeController() {
        System.out.println("----init snakeController");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("-------init1----snakeController---");
    }

    @PostConstruct
    public void init2(){
        System.out.println("---------init2-----");
    }

    public void init3(){
        System.out.println("---------int3-------");
    }
}
