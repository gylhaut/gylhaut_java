package com.gylhaut.spring_boot_start_demo.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//根据条件来注册不同的Bean
@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    //@Conditional({MySQLDatabaseTypeCondition.class})
    @DatabaseType("MySql")
    public UserDAO jdbcUserDAO(){
       return new JdbcUserDAO();
    }

    @Bean
   // @Conditional(MongoDBDatabaseTypeCondition.class)
    @DatabaseType("mongoDB")
    public UserDAO mongoUserDAo(){
        return new MongoUserDAO();
    }
}
