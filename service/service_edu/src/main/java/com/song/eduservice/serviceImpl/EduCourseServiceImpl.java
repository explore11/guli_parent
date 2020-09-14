package com.song.eduservice.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.song.eduservice.entity.EduCourse;
import com.song.eduservice.entity.EduCourseDescription;
import com.song.eduservice.entity.EduVideo;
import com.song.eduservice.entity.vo.CourseInfoVO;
import com.song.eduservice.entity.vo.CoursePublishVO;
import com.song.eduservice.mapper.EduCourseMapper;
import com.song.eduservice.rmt.VideoRmt;
import com.song.eduservice.service.EduChapterService;
import com.song.eduservice.service.EduCourseDescriptionService;
import com.song.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.song.eduservice.service.EduVideoService;
import com.song.servicebase.exception.GuLiException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    @Resource
    private EduVideoService eduVideoService;
    @Resource
    private EduChapterService eduChapterService;

    @Resource
    private VideoRmt videoRmt;

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


    @Override
    public CourseInfoVO queryCourseInfo(String courseId) {
        CourseInfoVO courseInfo = new CourseInfoVO();
        // 根据id查询课程信息
        EduCourse eduCourse = baseMapper.selectById(courseId);
        BeanUtils.copyProperties(eduCourse, courseInfo);

        // 根据id查询课程简介信息
        EduCourseDescription descriptionInfo = eduCourseDescriptionService.getById(courseId);
        courseInfo.setDescription(descriptionInfo.getDescription());
        return courseInfo;
    }


    @Override
    @Transactional
    public void updateCourseInfo(CourseInfoVO courseInfoVO) {
        // 保存课程的基本信息
        EduCourse updateEduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVO, updateEduCourse);
        int count = baseMapper.updateById(updateEduCourse);
        if (count == 0) {
            throw new GuLiException(20001, "更新课程信息失败");
        }
        String courseId = updateEduCourse.getId();
        // 保存简介的基本信息
        EduCourseDescription courseDescription = eduCourseDescriptionService.getById(courseId);
        courseDescription.setDescription(courseInfoVO.getDescription());
        eduCourseDescriptionService.updateById(courseDescription);
    }


    @Override
    public CoursePublishVO getCoursePublicInfo(String courseId) {
        CoursePublishVO publishVO = baseMapper.getCourseFinalInfo(courseId);
        return publishVO;
    }

    @Override
    @Transactional
    public boolean removeCourse(String curseId) {

        //根据课程id查询所有的视频信息
        QueryWrapper<EduVideo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", curseId);
        List<EduVideo> list = eduVideoService.list(queryWrapper);

        // 创建
        List<String> videoSourceIdList = new ArrayList<>();
        if (!list.isEmpty()) {
            for (EduVideo eduVideo : list) {
                videoSourceIdList.add(eduVideo.getVideoSourceId());
            }
        }

        if (!videoSourceIdList.isEmpty()) {
            videoRmt.deleteBatchVideo(videoSourceIdList);
        }

        //根据课程id删除小结
        eduVideoService.deleteVideoByCurseId(curseId);
        //根据课程id删除章节
        eduChapterService.deletedChapterInfoByCurseId(curseId);
        //根据课程id删除简介
        eduCourseDescriptionService.removeById(curseId);
        //根据课程id删除课程
        int count = baseMapper.deleteById(curseId);
        if (count == 0) {
            throw new GuLiException(20001, "删除课程失败");
        } else {
            return count > 0;
        }
    }
}
