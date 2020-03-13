package com.snake.ioc.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author snake
 * @date   2020/3/11 00:11
 */
@Service
public class QualifierService {
    @Autowired
    @Qualifier("qualifierImpl1")
    private QualifierDao qualifierDao;

    public void sayHello(){
        qualifierDao.printHello();
    }
}
