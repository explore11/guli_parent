package com.song.eduservice.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 会员表
 * </p>
 *
 * @author Song
 * @since 2020-09-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ucenter_member")
public class UcenterMember implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 微信openid
     */
    @TableField("openid")
    private String openid;

    /**
     * 手机号
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 性别 1 女，2 男
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 用户头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 用户签名
     */
    @TableField("sign")
    private String sign;

    /**
     * 是否禁用 1（true）已禁用，  0（false）未禁用
     */
    @TableField("is_disabled")
    private Boolean isDisabled;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableField("is_deleted")
    @TableLogic
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
