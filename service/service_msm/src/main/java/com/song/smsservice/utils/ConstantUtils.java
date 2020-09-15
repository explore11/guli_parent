package com.song.smsservice.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/* *
 * @program: guli_parent
 * @description 常量类，读取配置文件application.properties中的配置
 * @author: swq
 * @create: 2020-09-12 00:45
 **/
@Component
public class ConstantUtils implements InitializingBean {

    @Value("${aliyun.oss.file.accessKeyId}")
    private String keyId;
    @Value("${aliyun.oss.file.accessKeySecret}")
    private String keySecret;

    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;

    @Override
    public void afterPropertiesSet() {
        ACCESS_KEY_ID = keyId;
        ACCESS_KEY_SECRET = keySecret;
    }
}
