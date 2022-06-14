package com.example.idiom_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.idiom_backend.mapper")
public class IdiomBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdiomBackendApplication.class, args);
    }

}
