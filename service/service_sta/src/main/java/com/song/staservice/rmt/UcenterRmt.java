package com.song.staservice.rmt;

import com.song.commonutils.R;
import com.song.staservice.rmt.hytrix.UcenterHytrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-18 18:37
 **/
@Component
@FeignClient(value = "EDU-UCENTER", fallback = UcenterHytrix.class)
public interface UcenterRmt {

    @GetMapping("/eduUcenter/uCenterMember/countRegister/{day}")
    R registerCount(@PathVariable("day") String day);
}
