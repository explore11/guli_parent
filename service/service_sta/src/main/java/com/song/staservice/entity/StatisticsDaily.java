package com.song.staservice.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 网站统计日数据
 * </p>
 *
 * @author Song
 * @since 2020-09-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("statistics_daily")
public class StatisticsDaily implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 统计日期
     */
    @TableField("date_calculated")
    private String dateCalculated;

    /**
     * 注册人数
     */
    @TableField("register_num")
    private Integer registerNum;

    /**
     * 登录人数
     */
    @TableField("login_num")
    private Integer loginNum;

    /**
     * 每日播放视频数
     */
    @TableField("video_view_num")
    private Integer videoViewNum;

    /**
     * 每日新增课程数
     */
    @TableField("course_num")
    private Integer courseNum;

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
