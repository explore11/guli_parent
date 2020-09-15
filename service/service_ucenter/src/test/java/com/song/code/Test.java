package com.song.code;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @program: guli_parent
 * @description //TODO
 * @author: swq
 * @create: 2020-09-16 00:25
 **/
public class Test {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @org.junit.Test
    public void  fun(){

    }
}
