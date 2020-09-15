package com.song.educms.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 首页banner表
 * </p>
 *
 * @author Song
 * @since 2020-09-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("crm_banner")
public class CrmBanner implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 图片地址
     */
    @TableField("image_url")
    private String imageUrl;

    /**
     * 链接地址
     */
    @TableField("link_url")
    private String linkUrl;

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
    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
