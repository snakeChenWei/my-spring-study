package com.snake.aop.test;

import com.snake.aop.entity.Student;
import com.snake.aop.util.CommUtil;

/**
 * @author snake
 * on 2020/3/11 10:08.
 */
public class TestMain {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId(1);
        student.setName("33");
        System.out.println(CommUtil.buildSql(student));
    }
}
