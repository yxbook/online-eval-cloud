package com.sjy.eval.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: online-eval-cloud
 * @description:
 * @author: Created by youxun
 * @create: 2019-01-03 15:58
 **/
@FeignClient(value = "EVAL-AUTH",fallback = AuthClientApiHystric.class)
public interface AuthClientApi {

    @PostMapping("/auth/inserUser")
    int saveTest(@RequestParam("userName") String userName);

}
