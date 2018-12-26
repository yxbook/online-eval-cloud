package com.sjy.eval.auth.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: online-eval-clould
 * @description:
 * @author: Created by youxun
 * @create: 2018-12-17 16:27
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.sjy.eval.*.*.mapper")
@EnableSwagger2
public class AuthServerApplication {
    public static void main(String[] args) {
      SpringApplication.run(AuthServerApplication.class, args);
    }
}
