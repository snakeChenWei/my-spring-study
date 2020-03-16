package com.snake.service;

import com.snake.annotation.Snake;
import com.snake.dao.UserDaoImpl1;

@Snake("service")
public class UserServiceImpl implements UserService {

    UserDaoImpl1 dao;

    @Override
    public void find() {
        System.out.println("service");
        dao.query();
    }

    //public void setDao(UserDao dao) {
    // this.dao = dao;
    // }

    public void print(){
        System.out.println("====service===");
    }
}
