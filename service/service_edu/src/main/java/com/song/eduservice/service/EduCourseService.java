package com.song.eduservice.service;

import com.song.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.song.eduservice.entity.vo.CourseInfoVO;
import com.song.eduservice.entity.vo.CoursePublishVO;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Song
 * @since 2020-09-12
 */
public interface EduCourseService extends IService<EduCourse> {

    String addCourseInfo(CourseInfoVO courseInfoVO);

    CourseInfoVO queryCourseInfo(String courseId);

    void updateCourseInfo(CourseInfoVO courseInfoVO);

    CoursePublishVO getCoursePublicInfo(String courseId);
}
