package com.snake.is;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @auther: snake
 * @date: 2020/3/29 12:07
 */
@Target(ElementType.TYPE)
@Import(MyImportSelector.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableSnake {
}
