package com.song.eduorder.service;

import com.song.eduorder.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author Song
 * @since 2020-09-17
 */
public interface OrderService extends IService<Order> {

    String saveOrderInfo(String courseId, HttpServletRequest request);

}
