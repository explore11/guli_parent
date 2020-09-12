package com.song.eduservice.serviceImpl;

import com.song.eduservice.entity.EduCourse;
import com.song.eduservice.entity.EduCourseDescription;
import com.song.eduservice.entity.vo.CourseInfoVO;
import com.song.eduservice.mapper.EduCourseMapper;
import com.song.eduservice.service.EduCourseDescriptionService;
import com.song.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.song.servicebase.exception.GuLiException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author Song
 * @since 2020-09-12
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Resource
    private EduCourseDescriptionService eduCourseDescriptionService;

    @Override
    @Transactional
    public String addCourseInfo(CourseInfoVO courseInfoVO) {

        // 保存课程的基本信息
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVO, eduCourse);
        int count = baseMapper.insert(eduCourse);
        if (count == 0) {
            throw new GuLiException(20001, "保存课程信息失败");
        }
        //
        String courseId = eduCourse.getId();
        // 保存简介的基本信息

        EduCourseDescription description = new EduCourseDescription();
        description.setDescription(courseInfoVO.getDescription());
        description.setId(courseId);
        eduCourseDescriptionService.save(description);

        return courseId;
    }
}
