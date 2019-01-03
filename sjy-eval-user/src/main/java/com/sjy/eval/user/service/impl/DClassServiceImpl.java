package com.sjy.eval.user.service.impl;

import com.eval.common.base.BaseServiceImpl;
import com.sjy.eval.user.mapper.DClassMapper;
import com.sjy.eval.user.service.DClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @Description: DClass Service实现
* @Author: youxun
* @CreateDate: 2019/1/3.
* @Version: 1.0
**/
@Service
@Transactional
public class DClassServiceImpl extends BaseServiceImpl<DClassMapper, DClass> implements DClassService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DClassServiceImpl.class);

}