package com.woniuxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//扫包
@MapperScan("com.woniuxy.dao")
//事务管理
@EnableTransactionManagement
public class MrrsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MrrsApplication.class, args);
    }

}
