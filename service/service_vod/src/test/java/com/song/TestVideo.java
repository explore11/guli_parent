package com.song;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;

import java.util.List;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-14 09:52
 **/
public class TestVideo {
    public static void main(String[] args) throws Exception {
        //初始化客户端、请求对象和相应对象
        DefaultAcsClient client = AliYunVodSDKUtils.initVodClient("LTAI4GJUXkVyr1abdhxoqiwX", "InS0bT9nCWwh7sSecFz0ewj70xz1J3");
        // 请求和响应对象
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        GetPlayInfoResponse response = new GetPlayInfoResponse();

        // 获取响应对象
        response = getPlayInfo(client, "96cca277426b48fca12a277d8080d92c");

        List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
        //播放地址
        for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
            System.out.print("PlayInfo.PlayURL = " + playInfo.getPlayURL() + "\n");
        }
        //Base信息
        System.out.print("VideoBase.Title = " + response.getVideoBase().getTitle() + "\n");

    }


    public static GetPlayInfoResponse getPlayInfo(DefaultAcsClient client, String videoId) throws Exception {
        GetPlayInfoRequest request = new GetPlayInfoRequest();
        request.setVideoId(videoId);
        return client.getAcsResponse(request);
    }
}
