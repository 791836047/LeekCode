package com.whl.leekcode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.whl.leekcode.common.mapper")
public class LeekcodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeekcodeApplication.class, args);
    }

}
