package com.sjy.eval.user.client;

import org.springframework.stereotype.Component;

/**
 * @program: online-eval-cloud
 * @description: @Component 这个注解必须要加
 * @author: Created by youxun
 * @create: 2019-01-03 16:00
 **/
@Component
public class AuthClientApiHystric implements AuthClientApi{

    @Override
    public int saveTest(String userName) {
        System.out.println("进入断路器-saveTest。。。");
        throw new RuntimeException("saveTest 保存失败.");
    }
}
