package com.eval.common.base;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Description: BaseServiceImpl实现基类
 * @Author: youxun
 * @Version: 1.0
 **/
@Service
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<BaseMapper<T>, T> {

}
