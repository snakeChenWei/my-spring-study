package com.snake.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author snake
 * on 2020/3/11 17:46.
 */
@Aspect
@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
    /**
     * 申明切入点，匹配UserDao所有方法调用
     * execution匹配方法执行连接点
     * within:将匹配限制为特定类型中的连接点
     * args：参数
     * target：目标对象
     * this：代理对象
     */

    //execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
    @Pointcut("execution(public * com.snake.aop.service.*(java.lang.String,..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        System.out.println("----before------");
    }
}
