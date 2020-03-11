package com.snake.aop.util;

import com.snake.aop.anno.Table;

/**
 * @author snake
 * on 2020/3/11 10:07.
 */
public class CommUtil {

    public static String buildSql(Object o) {
        String baseSql = "select * from student where id = \\d and name=\\s";
        Class<?> aClass = o.getClass();
        System.out.println(aClass.isAnnotationPresent(Table.class));
        if (aClass.isAnnotationPresent(Table.class)) {
            Table table = aClass.getAnnotation(Table.class);
            System.out.println(table.key() + table.value());
        }
        return "";
    }
}
