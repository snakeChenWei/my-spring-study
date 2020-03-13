package com.snake.ioc;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

/**
 * @author snake
 * @date   2020/3/10 23:36
 */
@Controller
@Lazy
public class LazyController {
    public LazyController(){
        System.out.println("------LazyController-------");
    }
}
