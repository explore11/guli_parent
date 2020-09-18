package com.song.eduservice.rmt.hystrix;

import com.song.eduservice.rmt.OrderRmt;
import org.springframework.stereotype.Component;

/* *
 * @program: guli_parent
 * @description //TODO
 * @author: swq
 * @create: 2020-09-18 17:00
 **/
@Component
public class OrderRmtHystrix implements OrderRmt {
    @Override
    public boolean isBuyCourse(String memberId, String courseId) {
        return false;
    }
}
