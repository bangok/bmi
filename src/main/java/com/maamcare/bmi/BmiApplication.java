package com.maamcare.bmi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.maamcare.bmi.dao")
public class BmiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmiApplication.class, args);
    }

}
