package com.song.eduservice.controller;


import com.song.commonutils.R;
import com.song.eduservice.entity.subject.OneSubject;
import com.song.eduservice.service.EduSubjectService;
import com.sun.deploy.net.proxy.pac.PACFunctionsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.net.PortUnreachableException;
import java.security.PublicKey;
import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author Song
 * @since 2020-09-12
 */
@RestController
@RequestMapping("/eduService/eduSubject")
@CrossOrigin
public class EduSubjectController {
    @Autowired
    private EduSubjectService eduSubjectService;

    @PostMapping("/addSubject")
    public R addSubject(MultipartFile file) {
        eduSubjectService.addSubject(file, eduSubjectService);
        return R.success();
    }

    @GetMapping("/getAllSubjectByOneAndTwo")
    public R getAllSubjectByOneAndTwo() {
        List<OneSubject> subjects = eduSubjectService.getAllSubjectByOneAndTwo();
        return R.success().data("list", subjects);
    }

}

