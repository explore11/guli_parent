package com.song.videoservice.service;

import com.aliyun.oss.ClientException;
import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.song.servicebase.exception.GuLiException;
import com.song.videoservice.utils.AliYunVideoUtils;
import com.song.videoservice.utils.ConstantVideoUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-14 12:07
 **/
@Service
public class VideoServiceImpl implements VideoService {


    @Override
    public String uploadVideo(MultipartFile file) {
        try {
            String title = "";
            String fileName = file.getOriginalFilename();
            if (!StringUtils.isEmpty(fileName)) {
                title = fileName.substring(0, fileName.lastIndexOf("."));
            }
            InputStream inputStream = file.getInputStream();

            UploadStreamRequest request = new UploadStreamRequest(ConstantVideoUtils.ACCESS_KEY_ID, ConstantVideoUtils.ACCESS_KEY_SECRET, title, fileName, inputStream);
            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);

            String videoId = response.getVideoId();

            if (!response.isSuccess()) {
                String errorMessage = "阿里云上传错误：" + "code：" + response.getCode() + ", message：" + response.getMessage();
                System.out.println(errorMessage);
                if (StringUtils.isEmpty(videoId)) {
                    throw new GuLiException(20001, errorMessage);
                }
            }

            return response.getVideoId();
        } catch (Exception e) {
            throw new GuLiException(20001, "guli video 服务上传失败");
        }

    }

    @Override
    public void deleteVideo(String videoSourceId) {
        try {
            DefaultAcsClient client = AliYunVideoUtils.initVodClient(ConstantVideoUtils.ACCESS_KEY_ID, ConstantVideoUtils.ACCESS_KEY_SECRET);
            DeleteVideoRequest request = new DeleteVideoRequest();
            request.setVideoIds(videoSourceId);
            DeleteVideoResponse response = client.getAcsResponse(request);
            System.out.print("RequestId = " + response.getRequestId());
        } catch (Exception e) {
            throw new GuLiException(20001, "视频删除失败");
        }
    }

    @Override
    public void deleteBatchVideo(List<String> videoSourceIdList) {

        try {
            DefaultAcsClient client = AliYunVideoUtils.initVodClient(ConstantVideoUtils.ACCESS_KEY_ID, ConstantVideoUtils.ACCESS_KEY_SECRET);
            DeleteVideoRequest request = new DeleteVideoRequest();
            String videoSourceIds = org.apache.commons.lang.StringUtils.join(videoSourceIdList.toArray(), ",");
            request.setVideoIds(videoSourceIds);

            DeleteVideoResponse response = client.getAcsResponse(request);
            System.out.print("RequestId = " + response.getRequestId());
        } catch (Exception e) {
            throw new GuLiException(20001, "视频删除失败");
        }
    }
}
