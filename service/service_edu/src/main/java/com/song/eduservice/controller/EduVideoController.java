package com.song.eduservice.controller;


import com.song.commonutils.R;
import com.song.eduservice.entity.EduVideo;
import com.song.eduservice.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author Song
 * @since 2020-09-12
 */
@RestController
@RequestMapping("/eduService/eduVideo")
@CrossOrigin
public class EduVideoController {
    @Autowired
    private EduVideoService eduVideoService;


    /* *
     * 添加小结
     * @param eduVideo
     * @return
     */
    @PostMapping("/addVideoInfo")
    public R addVideoInfo(@RequestBody EduVideo eduVideo) {
        eduVideoService.save(eduVideo);
        return R.success();
    }


    /* *
     * 根据id删除小结
     * @param  videoId
     * @return
     */
    @DeleteMapping("/deleteVideoInfo/{videoId}")
    public R deleteVideoInfo(@PathVariable("videoId") String videoId) {

        boolean flag = eduVideoService.deleteVideoByVideoId(videoId);
        if (flag) {
            return R.success();
        } else {
            return R.error();
        }
    }


    /* *
     * 修改小结
     * @param eduVideo
     * @return
     */
    @PutMapping("/updateVideoInfo")
    public R updateVideoInfo(@RequestBody EduVideo eduVideo) {
        eduVideoService.updateById(eduVideo);
        return R.success();
    }

    /* *
     * 根据id查询小结
     * @param videoId
     * @return
     */
    @GetMapping("/getVideoInfo/{videoId}")
    public R getVideoInfo(@PathVariable("videoId") String videoId) {
        EduVideo eduVideo = eduVideoService.getById(videoId);
        return R.success().data("eduVideo", eduVideo);
    }
}

