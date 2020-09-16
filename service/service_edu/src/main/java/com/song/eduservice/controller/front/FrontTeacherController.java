package com.song.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.song.commonutils.R;
import com.song.eduservice.entity.EduCourse;
import com.song.eduservice.entity.EduTeacher;
import com.song.eduservice.service.EduCourseService;
import com.song.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/* *
 * @program: guli_parent
 * @description 前台的教师列表显示
 * @author: swq
 * @create: 2020-09-16 19:20
 **/
@CrossOrigin
@RestController
@RequestMapping("/eduService/eduTeacher")
public class FrontTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;
    @Autowired
    private EduCourseService eduCourseService;

    /* *
     * 前台获取教师列表
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/getTeacherPageListByFront/{currentPage}/{limit}")
    public R getTeacherPageListByFront(@PathVariable Long currentPage, @PathVariable Long limit) {
        Page<EduTeacher> page = new Page<EduTeacher>(currentPage, limit);
        Map<String, Object> map = eduTeacherService.getTeacherPageList(page);
        return R.success().data(map);
    }


    /* *
     * 根据讲师id 查询讲师详情
     * @param teacherId
     * @return
     */
    @GetMapping("/getTeacherDetail/{teacherId}")
    public R getTeacherDetail(@PathVariable("teacherId") String teacherId) {
        // 根据讲师id查询讲师信息
        EduTeacher eduTeacher = eduTeacherService.getById(teacherId);
        // 根据讲师id查询课程信息
        QueryWrapper<EduCourse> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.eq("teacher_id", teacherId);
        List<EduCourse> courseList = eduCourseService.list(courseQueryWrapper);
        return R.success().data("eduTeacher", eduTeacher).data("courseList", courseList);
    }

}
