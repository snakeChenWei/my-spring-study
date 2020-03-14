package com.snake.proxy;

import com.snake.proxy.service.SnakeService;
import com.snake.proxy.service.SnakeServiceImpl;
import com.snake.proxy.util.MyInvocationHandlerImpl;
import com.snake.proxy.util.MyProxy;
import com.snake.proxy.util.MyProxy2;
import com.snake.proxy.util.SnakeInvocationHandler;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author snake
 * @date 2020/3/12 22:36
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        SnakeService snakeService = (SnakeService) MyProxy.newInstance(new SnakeServiceImpl());
//        snakeService.printStr();
//        snakeService.sayName("陈", "威");

        // 自己的动态代理
        long startTime = System.currentTimeMillis();
        SnakeService snakeService = (SnakeService) MyProxy2.newInstance(
                SnakeService.class
                , new MyInvocationHandlerImpl(new SnakeServiceImpl()));
        snakeService.printStr();
        snakeService.sayName("陈", "威");
        long endTime = System.currentTimeMillis();
        System.out.println("耗时: " + (endTime - startTime));
        System.out.println();
        System.out.println();

        //jdk动态代理(生成的代理类需要继承Proxy) 所以jdk只能使用接口实现代理.
        long startTime2 = System.currentTimeMillis();
        SnakeService snakeServiceProxy = (SnakeService) Proxy.newProxyInstance(
                Main.class.getClassLoader()
                , new Class[]{SnakeService.class}
                , new SnakeInvocationHandler(new SnakeServiceImpl()));
        snakeServiceProxy.printStr();
        snakeServiceProxy.sayName("陈", "威");
        long endTime2 = System.currentTimeMillis();
        System.out.println("耗时: " + (endTime2 - startTime2));

        // 使用jdk,生成class文件(生成的代理类需要继承Proxy)
        byte[] bytes = ProxyGenerator.generateProxyClass("Proxy18", new Class[]{SnakeService.class});
        FileOutputStream fileOutputStream = new FileOutputStream("proxy/src/main/java/com/snake/proxy/service/$Proxy18.class");
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
