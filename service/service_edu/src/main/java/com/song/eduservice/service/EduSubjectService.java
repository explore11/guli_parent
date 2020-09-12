package com.song.eduservice.service;

import com.song.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.song.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author Song
 * @since 2020-09-12
 */
public interface EduSubjectService extends IService<EduSubject> {

    void addSubject(MultipartFile file,EduSubjectService eduSubjectService);

    List<OneSubject> getAllSubjectByOneAndTwo();
}
