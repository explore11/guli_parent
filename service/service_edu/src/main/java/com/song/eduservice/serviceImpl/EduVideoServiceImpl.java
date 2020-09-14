package com.song.eduservice.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.song.commonutils.R;
import com.song.eduservice.entity.EduVideo;
import com.song.eduservice.mapper.EduVideoMapper;
import com.song.eduservice.rmt.VideoRmt;
import com.song.eduservice.service.EduVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.song.servicebase.exception.GuLiException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.geom.QuadCurve2D;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author Song
 * @since 2020-09-12
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {
    @Resource
    private VideoRmt videoRmt;

    @Override
    public void deleteVideoByCurseId(String curseId) {
        QueryWrapper<EduVideo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", curseId);
        baseMapper.delete(queryWrapper);
    }

    @Override
    public boolean deleteVideoByVideoId(String videoId) {
        EduVideo eduVideo = baseMapper.selectById(videoId);
        //获取视频的源id
        String videoSourceId = eduVideo.getVideoSourceId();
        videoRmt.deleteVideo(videoSourceId);
        //再删除videoInfo
        int count = baseMapper.deleteById(videoId);
        if (count == 0) {
            throw new GuLiException(20001, "删除小结错误");
        } else {
            return count > 0;
        }
    }
}
