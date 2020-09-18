package com.song.eduorder.service;

import com.song.eduorder.entity.PayLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 支付日志表 服务类
 * </p>
 *
 * @author Song
 * @since 2020-09-17
 */
public interface PayLogService extends IService<PayLog> {

    Map<String, Object> createNativeCode(String orderNo);

    Map<String, String> queryPayStatus(String orderNo);

    void updateOrderStatus(Map<String, String> map);

}
