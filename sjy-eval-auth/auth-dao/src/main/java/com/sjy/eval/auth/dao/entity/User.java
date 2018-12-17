package com.sjy.eval.auth.dao.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author youxun
 * @since 2018-12-17
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    /**
     * 账号
     */
    @TableField("USER_ID")
    private String userId;
    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;
    /**
     * 身份证号(18位)
     */
    @TableField("PERSON_NUMBER")
    private String personNumber;
    /**
     * 状态（0;正常，-1：删除，1：禁用）
     */
    @TableField("STATUS")
    private Integer status;
    /**
     * 创建时间
     */
    @TableField("CREATE_DATE")
    private Date createDate;
    @TableField("UPDATE_TIME")
    private Date updateTime;
    @TableField("unique_number")
    private String uniqueNumber;
    /**
     * 学校编码（组织编码）
     */
    @TableField("schoool_code")
    private Integer schooolCode;
    @TableField("pwd_ming")
    private String pwdMing;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public Integer getSchooolCode() {
        return schooolCode;
    }

    public void setSchooolCode(Integer schooolCode) {
        this.schooolCode = schooolCode;
    }

    public String getPwdMing() {
        return pwdMing;
    }

    public void setPwdMing(String pwdMing) {
        this.pwdMing = pwdMing;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", userId=" + userId +
        ", password=" + password +
        ", personNumber=" + personNumber +
        ", status=" + status +
        ", createDate=" + createDate +
        ", updateTime=" + updateTime +
        ", uniqueNumber=" + uniqueNumber +
        ", schooolCode=" + schooolCode +
        ", pwdMing=" + pwdMing +
        "}";
    }
}
