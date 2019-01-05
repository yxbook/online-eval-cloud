package com.sjy.eval.user.service.impl;


import com.codingapi.tx.annotation.TxTransaction;
import com.eval.common.base.BaseServiceImpl;
import com.sjy.eval.user.client.AuthClientApi;
import com.sjy.eval.user.entity.User;
import com.sjy.eval.user.mapper.UserMapper;
import com.sjy.eval.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @Description: User Service实现
* @Author: youxun
* @CreateDate: 2018/12/17.
* @Version: 1.0
**/
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AuthClientApi authClientApi;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    @TxTransaction(isStart = true )
    public int testSave(User user) {

        userMapper.insert(user);
        System.out.println("执行事务操作111:" + user.getId());

        int id = authClientApi.saveTest("LNC");
        System.out.println("执行事务操作222:" + id);
        return id;
    }
}