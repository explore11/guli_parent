package com.song.eduservice.mapper;

import com.song.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.song.eduservice.entity.vo.CoursePublishVO;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author Song
 * @since 2020-09-12
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {

    CoursePublishVO getCourseFinalInfo(String courseId);
}
