package com.sjy.eval.auth.service.impl;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.codingapi.tx.annotation.TxTransaction;
import com.eval.common.base.BaseServiceImpl;
import com.sjy.eval.auth.entity.User;
import com.sjy.eval.auth.mapper.UserMapper;
import com.sjy.eval.auth.queryVo.UserQuerVo;
import com.sjy.eval.auth.service.UserService;
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

    @Override
    public List queryUserList(Pagination pagination, UserQuerVo querVo) {
        return userMapper.queryUserList(pagination, querVo);
    }

    @Override
    public List queryListbyCode(Pagination pagination, int code) {
        return userMapper.queryListbyCode(pagination, code);
    }

    @Override
    @TxTransaction
    public int inserUser(User user) {
        userMapper.insert(user);
        int ii = 100/0;
        return user.getId();
    }
}