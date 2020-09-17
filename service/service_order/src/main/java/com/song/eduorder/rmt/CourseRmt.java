package com.song.eduorder.rmt;

import com.song.eduorder.rmt.hytrix.CourseHytrix;
import com.song.servicebase.entity.CourseWebOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-17 23:52
 **/
@FeignClient(value = "EDU-SERVICE", fallback = CourseHytrix.class)
@Component
public interface CourseRmt {

    @GetMapping("/eduService/eduCourse/getCourseWebOrderInfo/{courserId}")
    public CourseWebOrder getCourseWebOrderInfo(@PathVariable("courserId") String courserId);

}
