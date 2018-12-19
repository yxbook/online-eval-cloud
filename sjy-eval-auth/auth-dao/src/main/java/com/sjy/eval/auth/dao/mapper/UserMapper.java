package com.sjy.eval.auth.dao.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.sjy.eval.auth.dao.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sjy.eval.auth.dao.queryVo.UserQuerVo;
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

    List queryUserList(Pagination pagination, @Param("query")UserQuerVo querVo);
}
