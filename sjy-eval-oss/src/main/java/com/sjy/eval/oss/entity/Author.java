package com.sjy.eval.oss.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: online-eval-clould
 * @description:
 * @author: Created by youxun
 * @create: 2018-12-26 09:51
 **/
@Data
public class Author implements Serializable {

    /**
     * 作者id
     */
    private Long id;
    /**
     * 作者姓名
     */
    private String name;
    /**
     * 作者简介
     */
    private String remark;
}
