package com.sjy.eval.user.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: youxun
 * @Date: 2018/12/17 11:16
 * @Description:
 */
@Configuration
@MapperScan(basePackages = "com.sjy.eval.auth.dao.mapper*")
public class MybatisPlusConfig {

    public MybatisPlusConfig() {
        System.out.println("springboot已经启动。。。");
    }     /**
     *   mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        System.out.println("执行日志");
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

}
