package com.sjy.eval.oss.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: online-eval-clould
 * @description:
 * @author: Created by youxun
 * @create: 2018-12-26 09:50
 **/
@Data
public class Tutorial implements Serializable{
    private Long id;
    private String name;//教程名称
}
