package com.song.pictureservice.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.song.pictureservice.utils.ConstantPropertiesUtil;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-12 00:51
 **/
@Service
public class PictureServiceImpl implements PictureService {
    @Override
    public String uploadFile(MultipartFile file) {

        // Endpoint以杭州为例，其它Region请按实际情况填写。
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String endpoint = ConstantPropertiesUtil.END_POINT;
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;


        try {
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 上传文件流。
            InputStream inputStream = file.getInputStream();
            // 获取文件名称
            String filename = file.getOriginalFilename();
            // 获取随机值
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            filename = uuid + filename;

            // 获取当前日期 yyyy/mm/dd格式的
            String datePath = new DateTime().toString("yyyy/MM/dd");
            // 拼接
            filename = datePath + "/" + filename;

            ossClient.putObject(bucketName, filename, inputStream);

            // 关闭OSSClient。
            ossClient.shutdown();
            String url = "";
            url = "https://" + bucketName + "." + endpoint + "/" + filename;
            return url;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
