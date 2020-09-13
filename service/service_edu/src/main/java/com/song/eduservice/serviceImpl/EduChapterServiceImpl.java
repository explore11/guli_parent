package com.song.eduservice.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.song.eduservice.entity.EduChapter;
import com.song.eduservice.entity.EduVideo;
import com.song.eduservice.entity.chapter.ChapterVO;
import com.song.eduservice.entity.chapter.VideoVO;
import com.song.eduservice.mapper.EduChapterMapper;
import com.song.eduservice.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.song.eduservice.service.EduVideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author Song
 * @since 2020-09-12
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {
    @Resource
    private EduVideoService eduVideoService;

    @Override
    public List<ChapterVO> getAllChapterVideo(String courseId) {
        //根据id获取所有的章节
        QueryWrapper<EduChapter> chapterVOQueryWrapper = new QueryWrapper<>();
        chapterVOQueryWrapper.eq("course_id", courseId);
        List<EduChapter> chapterList = baseMapper.selectList(chapterVOQueryWrapper);

        //根据id获取所有的小结
        QueryWrapper<EduVideo> videoQueryWrapper = new QueryWrapper<>();
        videoQueryWrapper.eq("course_id", courseId);
        List<EduVideo> eduVideoList = eduVideoService.list(videoQueryWrapper);

        // 最终返回
        List<ChapterVO> finalChapterList = new ArrayList<>();

        // 循环章节列表
        for (EduChapter eduChapter : chapterList) {
            ChapterVO chapterVO = new ChapterVO();
            BeanUtils.copyProperties(eduChapter, chapterVO);

            List<VideoVO> videoList = new ArrayList<>();
            // 循环小结
            for (EduVideo eduVideo : eduVideoList) {
                if (eduVideo.getChapterId().equals(eduChapter.getId())) {
                    VideoVO videoVO = new VideoVO();
                    BeanUtils.copyProperties(eduVideo, videoVO);
                    videoList.add(videoVO);
                }
            }
            // 添加小结到章节中
            chapterVO.setChildren(videoList);

            // 添加到返回中
            finalChapterList.add(chapterVO);
        }
        return finalChapterList;
    }
}
