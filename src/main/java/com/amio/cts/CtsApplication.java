package com.amio.cts;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.amio.cts.repository")
public class CtsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CtsApplication.class, args);
    }
}
