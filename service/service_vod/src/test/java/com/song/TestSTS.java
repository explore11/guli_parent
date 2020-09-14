package com.song;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;

/**
 * @program: guli_parent
 * @description 获取视频凭证
 * @author: swq
 * @create: 2020-09-14 10:09
 **/
public class TestSTS {
    public static void main(String[] args) throws Exception {
        DefaultAcsClient client = AliYunVodSDKUtils.initVodClient("LTAI4GJUXkVyr1abdhxoqiwX", "InS0bT9nCWwh7sSecFz0ewj70xz1J3");
        GetVideoPlayAuthResponse response = new GetVideoPlayAuthResponse();
        // 获取响应对象
        response = getVideoPlayAuth(client,"96cca277426b48fca12a277d8080d92c");

        //播放凭证
        System.out.print("PlayAuth = " + response.getPlayAuth() + "\n");
        //VideoMeta信息
        System.out.print("VideoMeta.Title = " + response.getVideoMeta().getTitle() + "\n");
    }

    /*获取播放凭证函数*/
    public static GetVideoPlayAuthResponse getVideoPlayAuth(DefaultAcsClient client, String videoId) throws Exception {
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        request.setVideoId(videoId);
        return client.getAcsResponse(request);
    }
}
