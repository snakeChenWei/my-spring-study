package com.snake.mybatis;

import com.snake.mybatis.service.MyImportBeanDefinitionRegistrar;
import com.snake.mybatis.service.SnakeMapperScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author snake
 * @date 2020/3/28 16:06.
 */
@Configuration
@ComponentScan(basePackages = "com.snake.mybatis.service")
@SnakeMapperScan
public class AppConfig {
}
