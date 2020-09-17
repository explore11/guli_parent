package com.song.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.song.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.song.eduservice.entity.frontVo.CourseQueryVO;
import com.song.eduservice.entity.frontVo.CourseWebVO;
import com.song.eduservice.entity.vo.CourseInfoVO;
import com.song.eduservice.entity.vo.CoursePublishVO;

import java.util.Map;

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

    boolean removeCourse(String id);

    Map<String, Object> getCourseList(Page<EduCourse> page, CourseQueryVO courseQueryVO);

    CourseWebVO getCourseDetails(String courseId);

}
