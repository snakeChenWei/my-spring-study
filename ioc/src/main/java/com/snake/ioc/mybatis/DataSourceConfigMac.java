package com.snake.ioc.mybatis;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @auther: snake
 * @date: 2020/3/11 00:17
 */
@Configuration
@Profile("mac") // todo 没生效 很奇怪
public class DataSourceConfigMac {
    public DataSourceConfigMac() {
        System.out.println("----init DataSourceConfigDev mac ----");
    }
    @Bean
    public SqlSessionFactoryBean DataSourceConfigDev() {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        System.out.println("----sqlSessionFactoryBean mac ----");
        return factoryBean;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("123456");
        System.out.println("----dataSource mac----");
        return driverManagerDataSource;
    }
}
