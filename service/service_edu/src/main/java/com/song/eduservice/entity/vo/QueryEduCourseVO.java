package com.song.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-13 20:53
 **/
@Data
public class QueryEduCourseVO {
    @ApiModelProperty(value = "课程名称")
    private String title;

    @ApiModelProperty(value = "课程发布状态")
    private String status;
}
