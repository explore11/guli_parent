package com.song.pictureservice.controller;

import com.song.commonutils.R;
import com.song.pictureservice.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-12 00:50
 **/
@RestController("/edu/oss")
public class PictureController {

    @Autowired
    private PictureService pictureService;


    @PostMapping("/upload")
    public R uploadFile(MultipartFile multipartFile) {
        String url = pictureService.uploadFile(multipartFile);
        return R.success().data("url", url);
    }


}
