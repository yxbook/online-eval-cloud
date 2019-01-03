package com.sjy.eval.auth.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.eval.common.base.BaseService;
import com.sjy.eval.auth.entity.User;
import com.sjy.eval.auth.queryVo.UserQuerVo;

import java.util.List;

/**
* @Description: User Service接口
* @Author: youxun
* @CreateDate: 2018/12/17.
* @Version: 1.0
**/
public interface UserService extends BaseService<User> {

    List queryUserList(Pagination pagination, UserQuerVo querVo);

    List queryListbyCode(Pagination pagination, int code);
}