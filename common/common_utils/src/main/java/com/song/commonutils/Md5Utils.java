package com.song.commonutils;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: zdd-analysis
 * @description:
 * @author: wangxingchao
 * @create: 2019/10/22 下午2:20
 **/
public class Md5Utils {


    public static final String salt = "ACCOUNT";

    /**
     * md5加密
     *
     * @param source 需要加密的字段
     * @param salt   盐
     * @param num    散列次数
     * @return 加密后的值
     */
    public static String md5(String source, String salt, int num) {
        if (StringUtils.isNotBlank(salt)) {
            source += salt;
        }
        StringBuilder builder = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes());
            byte[] b = md.digest();
            for (int value : b) {
                int i = value;
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    builder.append("0");
                }
                builder.append(Integer.toHexString(i));
            }
            if (num > 0) {
                source = md5(builder.toString(), salt, --num);
            }
        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }

        return source.toUpperCase();
    }

    public static String md5(String source) throws NoSuchAlgorithmException {
        return md5(source, null, 1);
    }

    public static void main(String[] args) {
        String s = md5("13716773391", Md5Utils.salt, 1);
        System.out.println(s);
    }
}
