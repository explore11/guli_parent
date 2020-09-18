package com.song.eduservice.rmt;

import com.song.eduservice.rmt.hystrix.OrderRmtHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-18 16:59
 **/
@Component
@FeignClient(name = "EDU-ORDER", fallback = OrderRmtHystrix.class)
public interface OrderRmt {
    @GetMapping("/eduOrder/order/isBuyCourse/{memberId}/{courseId}")
    boolean isBuyCourse(@PathVariable("memberId") String memberId, @PathVariable("courseId") String courseId);
}
