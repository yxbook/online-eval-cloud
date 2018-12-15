package com.eval.common.annotation;

import java.lang.annotation.*;

/**
 * @Description: 初始化继承BaseService的service
 * @Author: youxun
 * @Version: 1.0
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BaseService {
}
