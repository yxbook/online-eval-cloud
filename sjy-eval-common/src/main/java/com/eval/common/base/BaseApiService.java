package com.eval.common.base;

import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Description: REST实现伪RPC服务
 * @Author: youxun
 * @Version: 1.0
 **/
public interface BaseApiService<T> {
    
    @RequestMapping(value = "/insert" ,method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE)
    BaseResult insert(@RequestBody T entity);

    @RequestMapping(value = "/deleteById" ,method = RequestMethod.DELETE)
    BaseResult deleteById(@RequestParam("id") String id);

    @RequestMapping(value = "/updateById" ,method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE)
    BaseResult updateById(@RequestBody T entity);

    @RequestMapping(value = "/selectById" ,method = RequestMethod.GET)
    BaseResult<T> selectById(@RequestParam("id") String id);

    @RequestMapping(value = "/selectAll" ,method = RequestMethod.GET)
    BaseResult<List<T>> selectAll(@RequestParam Map<String, Object> params);

    @RequestMapping(value = "/selectPage" ,method = RequestMethod.GET)
    BaseResult<Page<T>> selectPage(@RequestParam Map<String, Object> params);


}
