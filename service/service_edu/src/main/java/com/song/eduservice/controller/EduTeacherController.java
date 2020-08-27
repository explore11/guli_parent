package com.song.eduservice.controller;


import com.song.eduservice.entity.EduTeacher;
import com.song.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Song
 * @since 2020-08-23
 */
@RestController
@RequestMapping("/eduService/eduTeacher")
public class EduTeacherController {
    @Resource
    private EduTeacherService eduTeacherService;

    @GetMapping("/queryAllEduTeacher")
    public List<EduTeacher> queryAllEduTeacher() {
        return eduTeacherService.list(null);
    }
}

