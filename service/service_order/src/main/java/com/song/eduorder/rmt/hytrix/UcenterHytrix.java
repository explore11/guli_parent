package com.song.eduorder.rmt.hytrix;

import com.song.eduorder.rmt.UcenterRmt;
import com.song.servicebase.entity.UcenterMemberOrder;
import org.springframework.stereotype.Component;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-17 23:49
 **/
@Component
public class UcenterHytrix implements UcenterRmt {
    @Override
    public UcenterMemberOrder getMemberOrderByUcenterId(String centerId) {
        return null;
    }
}
