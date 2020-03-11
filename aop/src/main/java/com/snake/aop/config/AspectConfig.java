package com.snake.aop.config;

import com.snake.aop.service.EmptySnakeService;
import com.snake.aop.service.SnakeService;
import com.snake.aop.service.SnakeServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author snake
 * on 2020/3/11 17:46.
 */
@Component
@Scope("prototype")
@Aspect("perthis(this(com.snake.aop.service.SnakeServiceImpl))") // 指定pointCut切点 下面的pointCut就无效了
//@Aspect()
public class AspectConfig {

    // 可以用接口,以及接口实现类, 代理匹配的类
//    @DeclareParents(value = "com.snake.aop.service.*",defaultImpl = SnakeServiceImpl.class)
//    private SnakeService snakeService;

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
    @Pointcut("execution(* com.snake.aop.service.*.*(..))")
    public void pointCutExecution() {

    }

    // 包名匹配
    @Pointcut("within(com.snake.aop.service.*)")
    public void pointCutWithin() {

    }

    // 参数名匹配
    @Pointcut("args(String,..)")
    public void pointCutArgs() {

    }

    // 代理对象匹配 proxyTargetClass  true cglib代理 类/接口, false jdk代理 接口
    @Pointcut("this(com.snake.aop.service.SnakeServiceImpl)")
    public void pointCutThis() {

    }

    // 目标对象匹配
    @Pointcut("target(com.snake.aop.service.SnakeService)")
    public void pointCutTarget() {

    }


    // 包名注解匹配
    @Pointcut("@within(com.snake.aop.anno.Table)")
    public void pointWithin() {

    }

    // 注解匹配(方法上)
    @Pointcut("@annotation(com.snake.aop.anno.Table)")
    public void pointAnnotation() {

    }

    // 注解匹配(方法上)
    @Pointcut("@args(com.snake.aop.anno.Table)")
    public void pointArgs() {

    }

//    @Before("pointCutExecution()")
//    public void before() {
//        System.out.println("----before------");
//    }
//
//    @After("pointCutExecution()")
//    public void after() {
//        System.out.println("----after------");
//    }


    // 环绕, ProceedingJoinPoint 是 JoinPoint的实现类. joinPoint 连接点
    @Around("pointCutExecution()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println(this.hashCode());
        try {
            Object[] args = proceedingJoinPoint.getArgs();
            for (int i = 0; i < args.length; i++) {
                args[i] += " 增强";
            }
            proceedingJoinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
