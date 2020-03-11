package com.snake.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author snake
 * on 2020/3/11 17:46.
 */
@Configuration
@ComponentScan("com.snake.aop")
@EnableAspectJAutoProxy(proxyTargetClass=false)// false 使用jdk代理 ,true 使用cglib代理
public class ApplicationConfig {

}
