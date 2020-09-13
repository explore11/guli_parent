package com.song.eduservice.entity.vo;

import lombok.Data;

/* *
 * @program: guli_parent
 * @description 课程发布的出参
 * @author: swq
 * @create: 2020-09-13 16:13
 **/
@Data
public class CoursePublishVO {
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;
}
