package com.song.videoservice.service;

import org.springframework.web.multipart.MultipartFile;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-14 12:07
 **/
public interface VideoService {
    String uploadVideo(MultipartFile file);

    void deleteVideo(String videoId);
}
