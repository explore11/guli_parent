package com.song.eduservice.controller;


import com.song.commonutils.R;
import com.song.eduservice.entity.vo.CourseInfoVO;
import com.song.eduservice.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author Song
 * @since 2020-09-12
 */
@RestController
@RequestMapping("/eduService/eduCourse")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;


    @PostMapping("/addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVO courseInfoVO) {
        String courseId = eduCourseService.addCourseInfo(courseInfoVO);
        return R.success().data("courseId", courseId);
    }

}

