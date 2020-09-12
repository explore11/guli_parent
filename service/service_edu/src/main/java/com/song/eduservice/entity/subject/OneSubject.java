package com.song.eduservice.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-12 17:07
 **/
@Data
public class OneSubject {
    private String id;
    private String title;
    List<TwoSubject> children  = new ArrayList<>();
}
