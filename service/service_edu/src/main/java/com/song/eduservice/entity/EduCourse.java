package com.song.eduservice.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 课程
 * </p>
 *
 * @author Song
 * @since 2020-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("edu_course")
public class EduCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 课程讲师ID
     */
    @TableField("teacher_id")
    private String teacherId;

    /**
     * 课程专业ID
     */
    @TableField("subject_id")
    private String subjectId;

    /**
     * 课程专业父级ID
     */
    @TableField("subject_parent_id")
    private String subjectParentId;

    /**
     * 课程标题
     */
    @TableField("title")
    private String title;

    /**
     * 课程销售价格，设置为0则可免费观看
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 总课时
     */
    @TableField("lesson_num")
    private Integer lessonNum;

    /**
     * 课程封面图片路径
     */
    @TableField("cover")
    private String cover;

    /**
     * 销售数量
     */
    @TableField("buy_count")
    private Long buyCount;

    /**
     * 浏览数量
     */
    @TableField("view_count")
    private Long viewCount;

    /**
     * 乐观锁
     */
    @TableField("version")
    private Long version;

    /**
     * 课程状态 Draft未发布  Normal已发布
     */
    @TableField("status")
    private String status;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableField("is_deleted")
    private Integer isDeleted;

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
