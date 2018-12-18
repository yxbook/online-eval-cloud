package com.sjy.eval.auth.server.controller;

import com.eval.common.base.BaseApiService;
import com.eval.common.base.BaseController;
import com.eval.common.base.BaseResult;
import com.eval.common.base.BaseResultEnum;
import com.sjy.eval.auth.dao.entity.User;
import com.sjy.eval.auth.dao.queryVo.UserQuerVo;
import com.sjy.eval.auth.server.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

/**
 * @program: online-eval-clould
 * @description:
 * @author: Created by youxun
 * @create: 2018-12-17 16:25
 **/
@RestController
@RequestMapping("/user")
@Api(tags ={ "用户信息"},description = "用户信息接口-网关路径/api-user")
public class UserController extends BaseController<User, UserService> implements BaseApiService<User>{

    //查询滚动动态信息
    @ApiOperation(value="分页查询测试", notes="参数：无")
    @PutMapping("/queryUserPage")
    public BaseResult queryUserPage(@RequestBody HashMap paramsMap) {
        //自动get/set
        UserQuerVo a = new UserQuerVo();
        User user = new User();
        user.setCreateDate(new Date());
        System.out.println(user.getCreateDate());
        return new BaseResult(BaseResultEnum.SUCCESS.status,"查询成功!", null);
    }

  /*  private Page buildPage(T friendQueryVo) {
        Page tPage =new Page(friendQueryVo.getPageNo(),friendQueryVo.getPageSize());
        if(StringUtils.isNotEmpty(friendQueryVo.getOrderBy())){
            tPage.setOrderByField(friendQueryVo.getOrderBy());
            tPage.setAsc(false);
        }
        if(StringUtils.isNotEmpty(friendQueryVo.getOrderByAsc())){
            tPage.setOrderByField(friendQueryVo.getOrderByAsc());
            tPage.setAsc(true);
        }
        return tPage;
    }*/



}
