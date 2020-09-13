package com.song.eduservice.entity.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-13 00:10
 **/
@Data
public class ChapterVO {
    private String id;
    private String title;
    private List<VideoVO> children =new ArrayList<>();
}
