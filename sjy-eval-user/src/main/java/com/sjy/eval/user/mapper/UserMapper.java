package com.sjy.eval.user.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sjy.eval.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author youxun
 * @since 2018-12-18
 */
public interface UserMapper extends BaseMapper<User>{

    List<User> selectAll();
}
