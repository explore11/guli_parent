package com.song.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.song.commonutils.R;
import com.song.eduservice.entity.EduCourse;
import com.song.eduservice.entity.EduTeacher;
import com.song.eduservice.entity.vo.CourseInfoVO;
import com.song.eduservice.entity.vo.CoursePublishVO;
import com.song.eduservice.entity.vo.QueryEduCourseVO;
import com.song.eduservice.entity.vo.QueryEduTeacherVO;
import com.song.eduservice.service.EduCourseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    /* *
     * 多条件查询分页
     * @param current
     * @param limit
     * @param queryEduTeacherVO
     * @return
     */
    @PostMapping("/multiQueryEduCoursePage/{current}/{limit}")
    public R multiQueryEduCoursePage(@PathVariable("current") long current,
                                     @PathVariable("limit") int limit,
                                     @RequestBody(required = false) QueryEduCourseVO queryEduCourseVO) {

        Page<EduCourse> page = new Page<>(current, limit);
        // 查询条件
        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();
        if (queryEduCourseVO != null && StringUtils.isNotEmpty(queryEduCourseVO.getTitle())) {
            queryWrapper.like("title", queryEduCourseVO.getTitle());
        }

        if (queryEduCourseVO != null && StringUtils.isNotEmpty(queryEduCourseVO.getStatus())) {
            queryWrapper.eq("status", queryEduCourseVO.getStatus());
        }
        // 排序
        queryWrapper.orderByDesc("gmt_create");
        // 分页 条件 查询数据
        eduCourseService.page(page, queryWrapper);

        Map<String, Object> map = new HashMap<>();
        map.put("totals", page.getTotal());
        map.put("list", page.getRecords());

        return R.success().data(map);
    }

    /* *
     * 逻辑删除课程
     * @param id
     * @return
     */
    @DeleteMapping("/deleteCourseById/{id}")
    public R deleteCourseById(@ApiParam(name = "id", value = "讲师id", required = true) @PathVariable("id") String id) {
        boolean flag = eduCourseService.removeCourse(id);
        if (flag) {
            return R.success();
        } else {
            return R.error();
        }
    }
}

