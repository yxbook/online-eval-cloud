package com.sjy.eval.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: online-eval-clould
 * @description:
 * @author: Created by youxun
 * @create: 2018-12-17 16:27
 **/
@SpringCloudApplication
@MapperScan(basePackages = "com.sjy.eval.user.mapper*")
@EnableSwagger2
public class UserServerApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(UserServerApplication.class, args);
    }

}
