package com.sjy.eval.user.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.eval.common.base.BaseController;
import com.eval.common.base.BaseResult;
import com.eval.common.base.BaseEnum;
import com.eval.common.util.StringUtils;
import com.sjy.eval.user.entity.User;
import com.sjy.eval.user.queryVo.UserQuerVo;
import com.sjy.eval.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @program: online-eval-clould
 * @description:
 * @author: Created by youxun
 * @create: 2018-12-17 16:25
 **/
@RestController
@RequestMapping("/user")
@Api(tags ={ "鉴权服务"},description = "鉴权服务接口-网关路径/api-auth")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    //查询滚动动态信息
    @PutMapping("/queryUserPage")
    @ApiOperation(value="分页查询测试", notes="参数：无")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="userQuerVo", name = "userId", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="userQuerVo", name = "password", value = "旧密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="userQuerVo", name = "newPassword", value = "新密码", required = true, dataType = "String")
    })
    public BaseResult queryUserPage(@RequestBody UserQuerVo querVo) {
        //自动get/set
        Page tPage = buildPage(querVo);
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("status", 0);
        List<User> userList = userService.selectByMap(paramsMap);
        tPage.setRecords(userList);
        System.out.println(userList);
        return new BaseResult(BaseEnum.SUCCESS.getStatus(), "查询成功", tPage);
    }

    private Page buildPage(UserQuerVo friendQueryVo) {
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
    }



}
