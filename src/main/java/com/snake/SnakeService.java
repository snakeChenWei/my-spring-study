package com.snake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

/**
 * @auther: snake
 * @date: 2020/3/9 22:45
 */
@Service
public abstract class SnakeService {

//    @Autowired
//    private SnakeDao snakeDao;

    // 通过构造方法注入
//    public SnakeService(SnakeDao snakeDao) {
//        this.snakeDao = snakeDao;
//    }


    // 通过set注入 set注入: byName 为set方法名称
//    public void setSnakeDao1(SnakeDao dao) {
//        this.dao = dao;
//    }


    @Lookup("snakeDao")
    public abstract SnakeDaoImpl getSnakeDao();

    public void printHello() {
//        snakeDao.printHello();
        System.out.println(this.hashCode());
        System.out.println(getSnakeDao().hashCode());
    }
}
