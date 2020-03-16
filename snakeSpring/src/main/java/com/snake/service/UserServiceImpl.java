package com.snake.service;

import com.snake.dao.UserDao;
import com.snake.dao.UserDaoImpl;
import com.snake.dao.UserDaoImpl1;

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
}
