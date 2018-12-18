package com.sjy.eval.auth.dao.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author youxun
 * @since 2018-12-18
 */
@Data
@Accessors(chain = true)
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


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}