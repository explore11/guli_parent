package com.song.eduservice.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 讲师
 * </p>
 * @author Song
 * @since 2020-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("edu_teacher")
public class EduTeacher implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 讲师ID
     */
      @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 讲师姓名
     */
    @TableField("name")
    private String name;

    /**
     * 讲师简介
     */
    @TableField("intro")
    private String intro;

    /**
     * 讲师资历,一句话说明讲师
     */
    @TableField("career")
    private String career;

    /**
     * 头衔 1高级讲师 2首席讲师
     */
    @TableField("level")
    private Integer level;

    /**
     * 讲师头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableField("is_deleted")
    @TableLogic
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create",fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified",fill = FieldFill.INSERT_UPDATE
    )
    private Date gmtModified;


}
