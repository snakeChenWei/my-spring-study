package com.snake.mybatis.service;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author snake
 * @date 2020/3/28 16:09.
 */
public interface SnakeDao {

    @Select("select * from user")
    String SelectUser();
}
