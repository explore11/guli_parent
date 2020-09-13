package com.song.eduservice.controller;


import com.song.commonutils.R;
import com.song.eduservice.entity.EduCourse;
import com.song.eduservice.entity.vo.CourseInfoVO;
import com.song.eduservice.entity.vo.CoursePublishVO;
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

    /* *
     * 添加课程信息
     * @param courseInfoVO
     * @return
     */
    @PostMapping("/addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVO courseInfoVO) {
        String courseId = eduCourseService.addCourseInfo(courseInfoVO);
        return R.success().data("courseId", courseId);
    }

    /* *
     * 根据id查询课程信息
     * @param courseId
     * @return
     */
    @GetMapping("/queryCourseInfo/{courseId}")
    public R queryCourseInfo(@PathVariable("courseId") String courseId) {
        CourseInfoVO courseInfoVO = eduCourseService.queryCourseInfo(courseId);
        return R.success().data("courseInfo", courseInfoVO);
    }


    /* *
     * 更新课程信息
     * @param courseId
     * @return
     */
    @PostMapping("/updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVO courseInfoVO) {
        eduCourseService.updateCourseInfo(courseInfoVO);
        return R.success();
    }


    /* *
     * 获取确认信息
     * @param courseId
     * @return
     */
    @GetMapping("/getCoursePublicInfo/{courseId}")
    public R getCoursePublicInfo(@PathVariable("courseId") String courseId) {
        CoursePublishVO coursePublishVO = eduCourseService.getCoursePublicInfo(courseId);
        return R.success().data("coursePublish", coursePublishVO);
    }


    /* *
     * 课程发布
     * @param eduCourse
     * @return
     */
    @PostMapping("/coursePublic/{courseId}")
    public R coursePublic(@PathVariable("courseId") String courseId) {
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(courseId);
        eduCourse.setStatus("Normal");
        eduCourseService.updateById(eduCourse);
        return R.success();
    }

}

