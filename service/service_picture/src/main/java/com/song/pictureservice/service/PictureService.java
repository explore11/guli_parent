package com.song.pictureservice.service;

import org.springframework.web.multipart.MultipartFile;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-12 00:51
 **/
public interface PictureService {
    String uploadFile(MultipartFile multipartFile);

}
