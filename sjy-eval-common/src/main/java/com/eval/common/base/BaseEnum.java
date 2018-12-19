package com.eval.common.base;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @Description: 接口结果常量枚举类
 * @Author: youxun
 * @Version: 1.0
 **/
@JsonSerialize(using = BaseResultEnumSerializer.class)
public enum BaseEnum {
    SUCCESS(200,"请求成功"),
    BLANK(400,"参数错误"),
    ERROR(500,"请求失败");
    public int status;
    public String msg;
    private BaseEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
