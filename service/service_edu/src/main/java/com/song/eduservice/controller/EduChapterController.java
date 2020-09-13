package com.song.eduservice.controller;


import com.song.commonutils.R;
import com.song.eduservice.entity.EduChapter;
import com.song.eduservice.entity.chapter.ChapterVO;
import com.song.eduservice.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.Cache;

import javax.annotation.security.PermitAll;
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

    /* *
     * 查询出全部的章节和小结
     * @param courseId
     * @return
     */
    @GetMapping("/getAllChapterVideo/{courseId}")
    public R getAllChapterVideo(@PathVariable("courseId") String courseId) {
        List<ChapterVO> list = eduChapterService.getAllChapterVideo(courseId);
        return R.success().data("list", list);
    }

    /* *
     * 添加章节
     * @param chapter
     * @return
     */
    @PostMapping("/addChapterInfo")
    public R addChapterInfo(@RequestBody EduChapter chapter) {
        eduChapterService.save(chapter);
        return R.success();
    }

    /* *
     * 根据id查询章节信息
     * @param chapterId
     * @return
     */
    @GetMapping("/getChapterInfo/{chapterId}")
    public R getChapterInfo(@PathVariable("chapterId") String chapterId) {
        EduChapter chapter = eduChapterService.getById(chapterId);
        return R.success().data("chapter", chapter);
    }

    /* *
     * 根据id更新章节信息
     * @param chapter
     * @return
     */
    @PutMapping("/updateChapterInfo")
    public R updateChapterInfo(@RequestBody EduChapter chapter) {
        eduChapterService.updateById(chapter);
        return R.success().data("chapter", chapter);
    }

    /* *
     * 删除章节信息
     * @param chapterId
     * @return
     */
    @DeleteMapping("/deletedChapterInfo/{chapterId}")
    public R deletedChapterInfo(@PathVariable("chapterId") String chapterId) {
        Boolean flag = eduChapterService.deletedChapterInfo(chapterId);
        if (flag) {
            return R.success();
        } else {
            return R.error();
        }
    }


}

