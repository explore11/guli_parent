package com.song.eduservice.rmt.hystrix;

import com.song.commonutils.R;
import com.song.eduservice.rmt.VideoRmt;
import org.springframework.stereotype.Component;

import java.util.List;

/* *
 * @program: guli_parent
 * @description 熔断
 * @author: swq
 * @create: 2020-09-14 18:09
 **/
@Component
public class VideoHystrix implements VideoRmt {
    @Override
    public R deleteVideo(String videoSourceId) {
        return R.error().message("删除失败");
    }

    @Override
    public R deleteBatchVideo(List<String> videoSourceIdList) {
        return R.error().message("批次删除失败");
    }
}
