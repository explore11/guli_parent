package com.song.eduorder.rmt;

import com.song.eduorder.rmt.hytrix.UcenterHytrix;
import com.song.servicebase.entity.UcenterMemberOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: guli_parent
 * @description //TODO
 * @author: swq
 * @create: 2020-09-17 23:48
 **/
@FeignClient(value = "EDU-UCENTER", fallback = UcenterHytrix.class)
@Component
public interface UcenterRmt {

    @GetMapping("/eduUcenter/uCenterMember/getMemberOrderByUcenterId/{ucenterId}")
    UcenterMemberOrder getMemberOrderByUcenterId(@PathVariable("ucenterId") String centerId);
}
