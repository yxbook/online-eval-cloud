package com.sjy.eval.auth.server.config;

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
@MapperScan("com.sjy.eval.auth.dao.mapper*")
public class MybatisPlusConfig {

    /**
     *   mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

}
