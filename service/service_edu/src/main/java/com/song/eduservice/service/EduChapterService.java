package com.song.eduservice.service;

import com.song.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.song.eduservice.entity.chapter.ChapterVO;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Song
 * @since 2020-09-12
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVO> getAllChapterVideo(String courseId);
}
