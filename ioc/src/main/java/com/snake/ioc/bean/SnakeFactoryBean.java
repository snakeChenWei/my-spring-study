package com.snake.ioc.bean;

import com.snake.ioc.SnakeDaoImpl;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @auther: snake
 * @date: 2020/3/17 00:49
 */
@Component("snakeFactoryBean")
public class SnakeFactoryBean implements FactoryBean {

    public void testBean(){
        System.out.println("testBean");
    }

    public Object getObject() throws Exception {
        return new DemoBean();
    }

    public Class<DemoBean> getObjectType() {
        return DemoBean.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
