package com.song.staservice.rmt.hytrix;

import com.song.commonutils.R;
import com.song.staservice.rmt.UcenterRmt;
import org.springframework.stereotype.Component;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-18 18:38
 **/
@Component
public class UcenterHytrix implements UcenterRmt {
    @Override
    public R registerCount(String day) {
        return R.error().message("失败");
    }
}
