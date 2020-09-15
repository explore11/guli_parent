package com.song.smsservice.controller;

import com.song.commonutils.R;
import com.song.commonutils.RandomUtil;
import com.song.smsservice.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* *
 * @program: guli_parent
 * @description 发送短信
 * @author: swq
 * @create: 2020-09-15 20:35
 **/
@RestController
@CrossOrigin
@RequestMapping("/eduSms/message")
public class SmsController {

    @Autowired
    private SmsService smsService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @GetMapping("/sendMessage/{phone}")
    public R sendMessage(@PathVariable("phone") String phone) {
        String codeByRedis = redisTemplate.opsForValue().get(phone);
        if (!StringUtils.isEmpty(codeByRedis)) {
            return R.success().message("已发送验证码,该验证码5分钟内有效");
        }
        String code = RandomUtil.getSixBitRandom();

        Map<String, String> params = new HashMap<>();
        params.put("code", code);

        boolean flag = smsService.sendMessage(params, phone);
        if (flag) {
            redisTemplate.opsForValue().set(phone, code, 5, TimeUnit.MINUTES);
            return R.success();
        } else {
            return R.error().message("发送短信失败");
        }
    }

}
