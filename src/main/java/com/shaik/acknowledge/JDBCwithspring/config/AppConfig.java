package com.shaik.acknowledge.JDBCwithspring.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    /**
     * Either you can specify in the application properties about the datasource how you want to handle or here
     * Only if you have to use specific customer datasource
     * **/
   /* @Bean
    public DataSource getDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/testing");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        return dataSource;
    }*/
}
