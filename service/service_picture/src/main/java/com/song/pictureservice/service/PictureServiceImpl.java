package com.song.pictureservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-12 00:51
 **/
@Service
public class PictureServiceImpl implements PictureService {
    @Override
    public String uploadFile(MultipartFile multipartFile) {

//
//        // Endpoint以杭州为例，其它Region请按实际情况填写。
//        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
//// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
//        String accessKeyId = "<yourAccessKeyId>";
//        String accessKeySecret = "<yourAccessKeySecret>";
//
//// 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//
//// 上传文件流。
//        InputStream inputStream = new FileInputStream("<yourlocalFile>");
//        ossClient.putObject("<yourBucketName>", "<yourObjectName>", inputStream);
//
//// 关闭OSSClient。
//        ossClient.shutdown();


        return null;
    }
}
