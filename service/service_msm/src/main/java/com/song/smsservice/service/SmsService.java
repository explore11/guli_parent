package com.song.smsservice.service;

import java.util.Map;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-15 20:37
 **/
public interface SmsService {
    boolean sendMessage(Map<String, String> params, String phone);
}
