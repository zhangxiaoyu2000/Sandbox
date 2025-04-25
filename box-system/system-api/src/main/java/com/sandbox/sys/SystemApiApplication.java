package com.sandbox.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.readcom.mapper")
public class SystemApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApiApplication.class, args);
    }

}
