package com.sjy.eval.auth.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: online-eval-clould
 * @description:
 * @author: Created by youxun
 * @create: 2018-12-17 16:27
 **/
@SpringCloudApplication
@ComponentScan(basePackages = {"com.sjy.eval.auth.server","com.sjy.eval.auth.dao", "com.sjy.eval.auth.dao.mapper"})
@MapperScan("com.sjy.eval.auth.dao.*")
@EnableSwagger2
public class AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }
}
