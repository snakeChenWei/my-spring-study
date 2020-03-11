package com.snake.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author snake
 * on 2020/3/11 17:46.
 */
@Aspect
@Component
public class AspectConfig {
    /**
     * 申明切入点，匹配UserDao所有方法调用
     * execution匹配方法执行连接点
     * within:将匹配限制为特定类型中的连接点
     * args：参数
     * target：目标对象
     * this：代理对象
     */
    // 精确匹配
    //execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
    @Pointcut("execution(public * com.snake.aop.service.*.*(java.lang.String))")
    public void pointCutExecution(){

    }

    // 包名匹配
    @Pointcut("within(com.snake.aop.service.*)")
    public void pointCutWithin(){

    }

    // 参数名匹配
    @Pointcut("args(String,..)")
    public void pointCutArgs(){

    }

    // 代理对象匹配 proxyTargetClass  true cglib代理 类/接口, false jdk代理 接口
    @Pointcut("this(com.snake.aop.service.SnakeServiceImpl)")
    public void pointCutThis(){

    }

    // 目标对象匹配
    @Pointcut("target(com.snake.aop.service.SnakeService)")
    public void pointCutTarget(){

    }


    // 包名注解匹配
    @Pointcut("@within(com.snake.aop.anno.Table)")
    public void pointWithin(){

    }

    // 注解匹配(方法上)
    @Pointcut("@annotation(com.snake.aop.anno.Table)")
    public void pointAnnotation(){

    }

    // 注解匹配(方法上)
    @Pointcut("@args(com.snake.aop.anno.Table)")
    public void pointArgs(){

    }

    @Before("pointCutThis()")
    public void before(){
        System.out.println("----before------");
    }
}
