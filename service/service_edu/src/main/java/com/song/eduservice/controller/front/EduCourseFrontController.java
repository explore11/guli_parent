package com.song.eduservice.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.song.commonutils.R;
import com.song.eduservice.entity.EduCourse;
import com.song.eduservice.entity.frontVo.CourseQueryVO;
import com.song.eduservice.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-16 22:24
 **/
@CrossOrigin
@RestController
@RequestMapping("/eduService/eduCourse")
public class EduCourseFrontController {
    @Autowired
    private EduCourseService eduCourseService;

    /* *
     * 条件查询前台的课程分页数据
     * @param currentPage
     * @param limit
     * @param courseQueryVO
     * @return
     */
    @PostMapping("/getPageListByFront/{currentPage}/{limit}")
    public R getPageListByFront(@PathVariable("currentPage") long currentPage,
                                @PathVariable("limit") long limit,
                                @RequestBody(required = false) CourseQueryVO courseQueryVO) {
        Page<EduCourse> page = new Page<>(currentPage, limit);
        Map<String, Object> map = eduCourseService.getCourseList(page, courseQueryVO);
        return R.success().data(map);
    }

}
