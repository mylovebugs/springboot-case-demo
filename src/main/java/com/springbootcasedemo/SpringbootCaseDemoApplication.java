package com.springbootcasedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.springbootcasedemo.*.mapper")
public class SpringbootCaseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCaseDemoApplication.class, args);
    }

}
