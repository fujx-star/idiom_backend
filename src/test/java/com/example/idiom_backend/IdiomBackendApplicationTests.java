package com.example.idiom_backend;

import com.example.idiom_backend.mapper.IdiomMapper;
import com.example.idiom_backend.service.IdiomService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class IdiomBackendApplicationTests {

    @Resource
    IdiomService service;

    @Test
    void contextLoads() {
        System.out.println(service.findIdiomByName("一壶千金"));
    }

    @Test
    void test1() {
        System.out.println(service.getOneRandomIdiom());
    }

}
