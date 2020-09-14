package com.song.eduservice.service;

import com.song.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author Song
 * @since 2020-09-12
 */
public interface EduVideoService extends IService<EduVideo> {

    void deleteVideoByCurseId(String curseId);

    boolean deleteVideoByVideoId(String videoId);
}
