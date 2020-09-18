package com.song.eduorder.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-18 12:33
 **/
@Component
public class ConstantWxPayUtil implements InitializingBean {
    @Value("${wx.pay.appid}")
    private String appId;

    @Value("${wx.pay.partner}")
    private String partner;

    @Value("${wx.pay.partnerkey}")
    private String partnerkey;

    @Value("${wx.pay.notifyurl}")
    private String notifyurl;


    public static String WX_PAY_APPID;
    public static String WX_PAY_PARTNER;
    public static String WX_PAY_PARTNERKEY;
    public static String WX_PAY_NOTIFYURL;


    @Override
    public void afterPropertiesSet() throws Exception {
        WX_PAY_APPID = appId;
        WX_PAY_PARTNER = partner;
        WX_PAY_PARTNERKEY = partnerkey;
        WX_PAY_NOTIFYURL = notifyurl;
    }
}
