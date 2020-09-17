package com.song.eduorder.rmt.hytrix;

import com.song.commonutils.R;
import com.song.eduorder.rmt.CourseRmt;
import com.song.servicebase.entity.CourseWebOrder;
import org.springframework.stereotype.Component;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-17 23:53
 **/
@Component
public class CourseHytrix implements CourseRmt {
    @Override
    public CourseWebOrder getCourseWebOrderInfo(String courserId) {
        return null;
    }
}
