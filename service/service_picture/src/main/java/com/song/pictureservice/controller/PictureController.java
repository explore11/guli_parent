package com.song.pictureservice.controller;

import com.song.commonutils.R;
import com.song.pictureservice.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-12 00:50
 **/
@RestController
@RequestMapping("/oss/picture")
@CrossOrigin
public class PictureController {

    @Resource
    private PictureService pictureService;

    @PostMapping("/upload")
    public R uploadFile(MultipartFile file) {
        String url = pictureService.uploadFile(file);
        return R.success().data("url", url);
    }


}
