package com.org.graduactionproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableTransactionManagement
@MapperScan("com.org.graduactionproject.dao")//(主要作用是扫包)
public class GraduactionprojectApplication {
    public static void main(String[] args) {
        SpringApplication.run(GraduactionprojectApplication.class, args);
    }

}

