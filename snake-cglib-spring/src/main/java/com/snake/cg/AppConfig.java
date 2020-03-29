package com.snake.cg;

import com.snake.cg.dao.SnakeDao1;
import com.snake.cg.dao.SnakeDao2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author snake
 * @date 2020/3/29 22:54
 */
@ComponentScan("com.snake.cg.dao")
@Configuration
public class AppConfig {

    @Bean
    public SnakeDao1 snakeDao1(){
        return new SnakeDao1();
    }


    @Bean
    public SnakeDao2 snakeDao2(){
        snakeDao1();
        return new SnakeDao2();
    }
}
