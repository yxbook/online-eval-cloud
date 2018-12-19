package com.eval.common.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @Description: 基础返回结果
 * @Author: youxun
 * @Version: 1.0
 **/
public class BaseResult<T> implements Serializable{
    /**
     * 状态码：200成功，其他为失败
     */
    public int status;

    /**
     * 成功为success，其他为失败原因
     */
    public String message;

    /**
     * 数据结果集
     */
    public T data;


    @Override
    public String toString() {
        return "BaseResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public BaseResult(BaseEnum baseEnum,
                      T data) {
        this(baseEnum.getStatus(), baseEnum.getMsg(), data);

    }

    //反序列化
    @JsonCreator
    public BaseResult(@JsonProperty(value = "status",required = true) int status,
                      @JsonProperty(value = "message",required = true) String message,
                      @JsonProperty(value = "data",required = true) T data) {

        this.status = status;
        this.message = message;
        this.data = data;
    }

}
