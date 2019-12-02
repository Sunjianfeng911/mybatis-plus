package com.mybatisplus.demo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true) // 开启事务,强制使用CGLIB代理,可选
@MapperScan("com.mybatisplus.demo.mapper") // 设置mapper接口的扫描包，必要
public class MybatisPlusConfig {
  /** 分页插件 */
  @Bean
  public PaginationInterceptor paginationInterceptor() {
    return new PaginationInterceptor();
  }
}
