package com.sjy.eval.auth.server.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.eval.common.base.BaseController;
import com.eval.common.base.BaseEnum;
import com.eval.common.base.BaseResult;
import com.eval.common.util.ValidateUtil;
import com.sjy.eval.auth.dao.queryVo.UserQuerVo;
import com.sjy.eval.auth.server.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    //查询滚动动态信息
    @PutMapping("queryUserPage")
    @ApiOperation(value="分页查询测试", notes="分页查询测试")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="userQuerVo", name = "code", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="userQuerVo", name = "password", value = "旧密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="userQuerVo", name = "newPassword", value = "新密码", required = true, dataType = "String")
    })
    public BaseResult queryUserPage(@RequestBody UserQuerVo userQuerVo) {
        //必要的入参校验以及日志打印
        if(ValidateUtil.isNull(userQuerVo.getCode())){
            return new BaseResult(BaseEnum.BLANK.status, "学校ID不能为空", false);
        }
        Page tPage = userQuerVo.buildPage();
        //List userList = userService.queryUserList(tPage,userQuerVo);
        List userList = userService.queryListbyCode(tPage, userQuerVo.getCode());
        tPage.setRecords(userList);
        return new BaseResult(BaseEnum.SUCCESS.getStatus(), "查询成功", tPage);
    }

}
