package com.song.eduservice.controller;


import com.song.commonutils.R;
import com.song.eduservice.entity.chapter.ChapterVO;
import com.song.eduservice.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author Song
 * @since 2020-09-12
 */
@RestController
@RequestMapping("/eduService/eduChapter")
@CrossOrigin
public class EduChapterController {

    @Autowired
    private EduChapterService eduChapterService;


    @GetMapping("/getAllChapterVideo/{courseId}")
    public R getAllChapterVideo(@PathVariable("courseId") String courseId) {
        List<ChapterVO> list = eduChapterService.getAllChapterVideo(courseId);
        return R.success().data("list", list);
    }

}

