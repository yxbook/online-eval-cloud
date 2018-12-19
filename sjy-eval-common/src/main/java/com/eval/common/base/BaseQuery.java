package com.eval.common.base;

import com.baomidou.mybatisplus.plugins.Page;
import com.eval.common.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: online-eval-clould
 * @description:
 * @author: Created by youxun
 * @create: 2018-12-17 18:15
 **/
@Setter
@Getter
public class BaseQuery {

    //表主键
    private int pKey;
    //当前页码
    private int pageNo = 1;
    //每页条数
    private int pageSize = 20;
    // 降序字段
    private String orderBy;
    // 升序字段
    private String orderByAsc;

    public Page buildPage() {
        Page tPage =new Page(this.pageNo,this.pageSize);
        if(StringUtils.isNotEmpty(this.orderBy)){
            tPage.setOrderByField(this.orderBy);
            tPage.setAsc(false);
        }
        if(StringUtils.isNotEmpty(this.orderByAsc)){
            tPage.setOrderByField(this.orderByAsc);
            tPage.setAsc(true);
        }
        return tPage;
    }
}
