package com.song.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.song.commonutils.R;
import com.song.eduservice.entity.EduTeacher;
import com.song.eduservice.entity.vo.QueryEduTeacherVO;
import com.song.eduservice.service.EduTeacherService;
import com.song.servicebase.exception.GuLiException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections4.Get;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Song
 * @since 2020-08-23
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduService/eduTeacher")
public class EduTeacherController {
    @Resource
    private EduTeacherService eduTeacherService;

    @ApiOperation(value = "查询讲师列表")
    @GetMapping("/queryAllEduTeacher")
    public R queryAllEduTeacher() {
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.success().data("list", list);
    }

    @ApiOperation(value = "分页查询讲师列表")
    @GetMapping("/queryAllByPage/{current}/{limit}")
    public R queryAllByPage(@PathVariable("current") long current,
                            @PathVariable("limit") int limit) {

        Page<EduTeacher> page = new Page<>(current, limit);
        //查询
        eduTeacherService.page(page, null);

        Map<String, Object> map = new HashMap<>();
        map.put("totals", page.getTotal());
        map.put("list", page.getRecords());

        return R.success().data(map);
    }

    // 组合条件带分页查询教师列表信息
    @PostMapping("/multiQueryEduTeacherPage/{current}/{limit}")
    public R multiQueryEduTeacherPage(@PathVariable("current") long current,
                                      @PathVariable("limit") int limit,
                                      @RequestBody(required = false) QueryEduTeacherVO queryEduTeacherVO) {

        Page<EduTeacher> page = new Page<>(current, limit);
        // 查询条件
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        if (queryEduTeacherVO != null && StringUtils.isNotEmpty(queryEduTeacherVO.getName())) {
            queryWrapper.like("name", queryEduTeacherVO.getName());
        }

        if (queryEduTeacherVO != null && null != queryEduTeacherVO.getLevel()) {
            queryWrapper.eq("level", queryEduTeacherVO.getLevel());
        }

        if (queryEduTeacherVO != null && null != queryEduTeacherVO.getStart()) {
            queryWrapper.ge("gmt_create", queryEduTeacherVO.getStart());
        }

        if (queryEduTeacherVO != null && null != queryEduTeacherVO.getStart()) {
            queryWrapper.le("gmt_create", queryEduTeacherVO.getEnd());
        }
        // 分页 条件 查询数据
        eduTeacherService.page(page, queryWrapper);

        Map<String, Object> map = new HashMap<>();
        map.put("totals", page.getTotal());
        map.put("list", page.getRecords());

        return R.success().data(map);
    }


    @ApiOperation(value = "逻辑删除讲师")
    @DeleteMapping("/{id}")
    public R queryAllEduTeacher(@ApiParam(name = "id", value = "讲师id", required = true) @PathVariable("id") String id) {
        boolean flag = eduTeacherService.removeById(id);
        if (flag) {
            return R.success();
        } else {
            return R.error();
        }
    }

    @ApiOperation(value = "添加讲师")
    @PostMapping("/addEduTeacher")
    public R addEduTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean flag = eduTeacherService.save(eduTeacher);
        if (flag) {
            return R.success();
        } else {
            return R.error();
        }
    }

    @ApiOperation(value = "查询讲师")
    @GetMapping("/queryEduTeacher/{id}")
    public R queryEduTeacher(@PathVariable("id") String id) {
        EduTeacher eduTeacher = eduTeacherService.getById(id);
//        try {
//            int i = 10 / 0;
//        }catch (Exception e){
//            throw new GuLiException(20001,"错误页面");
//        }
        return R.success().data("eduTeacher", eduTeacher);
    }

    @ApiOperation(value = "更新讲师")
    @PostMapping("/updateEduTeacher")
    public R updateEduTeacher(@RequestBody EduTeacher updateEduTeacher) {
        return eduTeacherService.updateById(updateEduTeacher) ? R.success() : R.error();
    }

}

