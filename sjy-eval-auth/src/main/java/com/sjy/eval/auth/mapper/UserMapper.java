package com.sjy.eval.auth.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.sjy.eval.auth.entity.User;
import com.sjy.eval.auth.queryVo.UserQuerVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author youxun
 * @since 2018-12-19
 */
public interface UserMapper extends BaseMapper<User> {

    List queryUserList(Pagination pagination, @Param("query") UserQuerVo querVo);

    List queryListbyCode(Pagination pagination, @Param("code") int code);
}
