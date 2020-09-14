package com.song.videoservice.controller;

import com.song.commonutils.R;
import com.song.videoservice.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-14 12:06
 **/
@RestController
@RequestMapping("/eduVideo/video")
@CrossOrigin
public class VideoController {
    @Autowired
    private VideoService videoService;


    /* *
     * 上传视频
     * @param file
     * @return
     */
    @PostMapping("/uploadVideo")
    public R uploadVideo(MultipartFile file) {
        String videoSourceId = videoService.uploadVideo(file);
        return R.success().data("videoId", videoSourceId);
    }

    /* *
     * 删除视频
     * @param videoId
     * @return
     */
    @DeleteMapping("/deleteVideo/{videoSourceId}")
    public R deleteVideo(@PathVariable("videoSourceId") String videoSourceId) {
        videoService.deleteVideo(videoSourceId);
        return R.success();
    }

    /* *
     * 批量删除多个
     * @param videoIdList
     * @return
     */
    @DeleteMapping("/deleteBatchVideo")
    public R deleteBatchVideo(@RequestParam("videoSourceIdList") List<String> videoSourceIdList) {
        videoService.deleteBatchVideo(videoSourceIdList);
        return R.success();
    }
}
