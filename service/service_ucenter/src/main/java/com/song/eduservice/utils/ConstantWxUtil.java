package com.song.eduservice.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-16 15:29
 **/
@Component
public class ConstantWxUtil implements InitializingBean {

    @Value("${wx.open.appId}")
    private String appId;

    @Value("${wx.open.appSecret}")
    private String appSecret;

    @Value("${wx.open.redirectUrl}")
    private String redirectUrl;


    public static String WX_OPEN_APP_ID;
    public static String WX_OPEN_APP_SECRET;
    public static String WX_OPEN_REDIRECT_URL;


    @Override
    public void afterPropertiesSet() throws Exception {
        WX_OPEN_APP_ID = appId;
         WX_OPEN_APP_SECRET = appSecret;
        WX_OPEN_REDIRECT_URL = redirectUrl;
    }
}
