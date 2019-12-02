package com.mybatisplus.demo;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
@SpringBootApplication
@MapperScan("com.mybatisplus.demo.mapper")
public class MybatisPlusApplication {

  public static void main(String[] args) {
    SpringApplication.run(MybatisPlusApplication.class, args);
  }
}
