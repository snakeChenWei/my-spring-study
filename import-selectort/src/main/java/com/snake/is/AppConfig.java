package com.snake.is;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @auther: snake
 * @date: 2020/3/29 12:26
 */
@EnableSnake()
@ComponentScan("com.snake.is.dao")
public class AppConfig {
}
