package com.snake.is;

import com.snake.is.dao.SnakeDao1;
import com.snake.is.dao.SnakeDao2;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @auther: snake
 * @date: 2020/3/29 12:06
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{SnakeDao1.class.getName()};
    }
}
