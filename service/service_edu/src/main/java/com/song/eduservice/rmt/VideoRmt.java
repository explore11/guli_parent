package com.song.eduservice.rmt;

import com.song.commonutils.R;
import com.song.eduservice.rmt.hystrix.VideoHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/* *
 * @program: guli_parent
 * @description video的RMT调用
 * @author: swq
 * @create: 2020-09-14 16:21
 **/
@Component
@FeignClient(name = "EDU-VIDEO", fallback = VideoHystrix.class)
public interface VideoRmt {

    /* *
     * 删除单个视频
     * @param videoSourceId
     * @return
     */
    @DeleteMapping("/eduVideo/video/deleteVideo/{videoSourceId}")
    R deleteVideo(@PathVariable("videoSourceId") String videoSourceId);


    /* *
     * 批量删除
     * @param videoSourceIdList
     * @return
     */
    @DeleteMapping("/eduVideo/video/deleteBatchVideo")
    R deleteBatchVideo(@RequestParam("videoSourceIdList") List<String> videoSourceIdList);

}
