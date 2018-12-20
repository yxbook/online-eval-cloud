package com.sjy.eval.user;

import com.sjy.eval.user.entity.User;
import com.sjy.eval.user.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @program: online-eval-clould
 * @description:
 * @author: Created by youxun
 * @create: 2018-12-17 16:27
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.sjy.eval.user.mapper*")
@EnableSwagger2
public class UserServerApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(UserServerApplication.class, args);

        UserMapper userMapper = context.getBean(UserMapper.class);


        List lsit = userMapper.selectAll();
        System.out.println(lsit.size());


        User user = userMapper.selectById(1);
        System.out.println(user.getCreateDate());


        List lsit1 = userMapper.selectUserTest();
        System.out.println(lsit1.size());
    }


}
