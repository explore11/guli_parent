package com.song.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.song.eduservice.entity.EduSubject;
import com.song.eduservice.entity.vo.ExcelSubjectData;
import com.song.eduservice.service.EduSubjectService;
import com.song.servicebase.exception.GuLiException;

/* *
 * @program: guli_parent
 * @description:  监听器自己使用  不交给spring管理
 * @author: swq
 * @create: 2020-09-12 13:02
 **/
public class ExcelSubjectListener extends AnalysisEventListener<ExcelSubjectData> {

    public EduSubjectService subjectService;

    public ExcelSubjectListener() {
    }
    public ExcelSubjectListener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public void invoke(ExcelSubjectData excelSubjectData, AnalysisContext analysisContext) {
        if (excelSubjectData == null){
            throw new GuLiException(20001,"文件数据为空");
        }

        // 判断一级分类是否重复
        EduSubject exitOneSubject = this.judgeOneSubject(subjectService, excelSubjectData.getOneSubjectName());
        if (exitOneSubject == null){ // 如果为null 说明不重复
            exitOneSubject = new EduSubject();
            exitOneSubject.setTitle(excelSubjectData.getOneSubjectName());
            exitOneSubject.setParentId("0");
            subjectService.save(exitOneSubject);
        }

        // 判断二级分类是否重复
        EduSubject exitTwoSubject = this.judgeTwoSubject(subjectService, excelSubjectData.getTwoSubjectName(), exitOneSubject.getParentId());
        if (exitTwoSubject == null){ // 如果为null 说明不重复
            exitTwoSubject = new EduSubject();
            exitTwoSubject.setTitle(excelSubjectData.getTwoSubjectName());
            exitTwoSubject.setParentId(exitOneSubject.getId());
            subjectService.save(exitTwoSubject);
        }
    }

    // 判断一级分类是否重复

    private EduSubject judgeOneSubject(EduSubjectService subjectService,String name){
        QueryWrapper<EduSubject> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("parent_id","0");
        queryWrapper.eq("title",name);
        return subjectService.getOne(queryWrapper);
    }


    // 判断二级分类是否重复
    private EduSubject judgeTwoSubject(EduSubjectService subjectService,String name,String pid){
        QueryWrapper<EduSubject> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("parent_id",pid);
        queryWrapper.eq("title",name);
        return subjectService.getOne(queryWrapper);
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
