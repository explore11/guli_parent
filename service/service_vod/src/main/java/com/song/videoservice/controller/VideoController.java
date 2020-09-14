package com.song.videoservice.controller;

import com.song.commonutils.R;
import com.song.videoservice.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.GET;

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
        String videoId = videoService.uploadVideo(file);
        return R.success().data("videoId", videoId);
    }

    /* *
     * 删除视频
     * @param videoId
     * @return
     */
    @DeleteMapping("/deleteVideo/{videoId}")
    public R deleteVideo(@PathVariable("videoId") String videoId) {
        videoService.deleteVideo(videoId);
        return R.success();
    }
}
