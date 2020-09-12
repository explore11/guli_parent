package com.song.eduservice.serviceImpl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.song.eduservice.entity.EduSubject;
import com.song.eduservice.entity.subject.OneSubject;
import com.song.eduservice.entity.subject.TwoSubject;
import com.song.eduservice.entity.vo.ExcelSubjectData;
import com.song.eduservice.listener.ExcelSubjectListener;
import com.song.eduservice.mapper.EduSubjectMapper;
import com.song.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.velocity.runtime.directive.contrib.For;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author Song
 * @since 2020-09-12
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    @Transactional
    public void addSubject(MultipartFile file, EduSubjectService eduSubjectService) {

        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, ExcelSubjectData.class, new ExcelSubjectListener(eduSubjectService)).sheet().doRead();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<OneSubject> getAllSubjectByOneAndTwo() {
        //查询一级分类
        QueryWrapper<EduSubject> oneQueryWrapper = new QueryWrapper<>();
        oneQueryWrapper.eq("parent_id", "0");
        List<EduSubject> oneSubjectList = baseMapper.selectList(oneQueryWrapper);

        //查询二级分类
        QueryWrapper<EduSubject> twoQueryWrapper = new QueryWrapper<>();
        twoQueryWrapper.ne("parent_id", "0");
        List<EduSubject> twoSubjectList = baseMapper.selectList(twoQueryWrapper);

        // 最终返回的数据类型
        List<OneSubject> finalSubjectList = new ArrayList<>();
        for (EduSubject oneEduSubject : oneSubjectList) {
            OneSubject oneSubject = new OneSubject();
            BeanUtils.copyProperties(oneEduSubject, oneSubject);

            // 添加二级分类
            List<TwoSubject> twoSubjects = new ArrayList<>();
            for (EduSubject twoEduSubject : twoSubjectList) {
                if (twoEduSubject.getParentId().equals(oneEduSubject.getId())) {
                    TwoSubject twoSubject = new TwoSubject();
                    BeanUtils.copyProperties(twoEduSubject, twoSubject);
                    twoSubjects.add(twoSubject);
                }
            }

            // 添加二级分类到一级分类中
            oneSubject.setChildren(twoSubjects);
            //最终返回
            finalSubjectList.add(oneSubject);
        }
        return finalSubjectList;
    }
}
