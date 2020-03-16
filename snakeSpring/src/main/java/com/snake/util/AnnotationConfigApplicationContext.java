package com.snake.util;

import com.snake.annotation.Snake;

import java.io.File;

/**
 * @auther: snake
 * @date: 2020/3/16 23:57
 */
public class AnnotationConfigApplicationContext {
    public void scan(String basePackage) {
        String rootPath = this.getClass().getResource("/").getPath(); //获取项目路径
        String basePackagePath = basePackage.replaceAll("\\.", "\\\\");
        File file = new File(rootPath + "\\" + basePackagePath);
        printClass(file);
    }

    private void printClass(File file) {
        if (file.isFile()) {
            try {
                String path = file.getPath();
                path = path.substring(this.getClass().getResource("/").getPath().length() - 1);

                Class clazz = Class.forName(path.replaceAll("\\\\", "\\.").replaceAll("\\.class", ""));
                //判断是否含有@snake
                if (clazz.isAnnotationPresent(Snake.class)) {
                    Snake snake = (Snake) clazz.getAnnotation(Snake.class);
                    System.out.println(snake.value());
                    System.out.println(clazz.newInstance());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (file.isDirectory() && file.list().length > 0) {
            for (File fileSecond : file.listFiles()) {
                printClass(fileSecond);
            }
        }
    }
}
