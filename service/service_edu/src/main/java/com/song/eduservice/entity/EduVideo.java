package com.song.eduservice.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 课程视频
 * </p>
 *
 * @author Song
 * @since 2020-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("edu_video")
public class EduVideo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 视频ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 课程ID
     */
    @TableField("course_id")
    private String courseId;

    /**
     * 章节ID
     */
    @TableField("chapter_id")
    private String chapterId;

    /**
     * 节点名称
     */
    @TableField("title")
    private String title;

    /**
     * 云端视频资源
     */
    @TableField("video_source_id")
    private String videoSourceId;

    /**
     * 原始文件名称
     */
    @TableField("video_original_name")
    private String videoOriginalName;

    /**
     * 排序字段
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 播放次数
     */
    @TableField("play_count")
    private Long playCount;

    /**
     * 是否可以试听：0收费 1免费
     */
    @TableField("is_free")
    private Boolean isFree;

    /**
     * 视频时长（秒）
     */
    @TableField("duration")
    private Float duration;

    /**
     * Empty未上传 Transcoding转码中  Normal正常
     */
    @TableField("status")
    private String status;

    /**
     * 视频源文件大小（字节）
     */
    @TableField("size")
    private Long size;

    /**
     * 乐观锁
     */
    @TableField("version")
    private Long version;

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
