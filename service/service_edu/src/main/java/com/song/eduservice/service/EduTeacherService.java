package com.song.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.song.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author Song
 * @since 2020-08-23
 */
public interface EduTeacherService extends IService<EduTeacher> {
    Map<String, Object> getTeacherPageList(Page<EduTeacher> page);
}
