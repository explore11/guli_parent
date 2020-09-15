package com.song.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.song.commonutils.R;
import com.song.eduservice.entity.EduCourse;
import com.song.eduservice.entity.EduTeacher;
import com.song.eduservice.service.EduCourseService;
import com.song.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-15 12:01
 **/
@CrossOrigin
@RestController
@RequestMapping("/eduService/index")
public class IndexFrontController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @Autowired
    private EduCourseService eduCourseService;

    @GetMapping("/getData")
    public R getData() {

        // 获取8个热门课程
        QueryWrapper<EduCourse> queryWrapperCourse = new QueryWrapper<>();
        queryWrapperCourse.orderByDesc("id");
        queryWrapperCourse.last("limit 8");
        List<EduCourse> eduCourseList = eduCourseService.list(queryWrapperCourse);

        // 获取四个名师
        QueryWrapper<EduTeacher> queryWrapperTeacher = new QueryWrapper<>();
        queryWrapperTeacher.orderByDesc("id");
        queryWrapperTeacher.last("limit 4");
        List<EduTeacher> eduTeacherList = eduTeacherService.list(queryWrapperTeacher);

        return R.success().data("eduTeacherList", eduTeacherList).data("eduCourseList", eduCourseList);
    }


}
