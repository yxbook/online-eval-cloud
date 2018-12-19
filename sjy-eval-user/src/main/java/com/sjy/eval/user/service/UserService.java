package com.sjy.eval.user.service;

import com.eval.common.base.BaseService;
import com.sjy.eval.user.entity.User;

import java.util.List;

/**
* @Description: User Service接口
* @Author: youxun
* @CreateDate: 2018/12/17.
* @Version: 1.0
**/
public interface UserService extends BaseService<User> {

    List<User> selectAll();
}