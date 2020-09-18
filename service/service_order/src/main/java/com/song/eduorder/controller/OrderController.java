package com.song.eduorder.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.song.commonutils.R;
import com.song.eduorder.entity.Order;
import com.song.eduorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author Song
 * @since 2020-09-17
 */
@RestController
@RequestMapping("/eduOrder/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;


    /* *
     * 添加订单
     * @param courseId
     * @return
     */
    @PostMapping("/saveOrderInfo/{courseId}")
    public R saveOrderInfo(@PathVariable("courseId") String courseId, HttpServletRequest request) {
        String orderNo = orderService.saveOrderInfo(courseId, request);
        return R.success().data("orderNo", orderNo);
    }

    /* *
     * 根据订单编号查询订单信息
     * @param orderNo
     * @return
     */
    @GetMapping("/getOrderInfoByOrderNo/{orderNo}")
    public R getOrderInfoByOrderNo(@PathVariable("orderNo") String orderNo) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_no", orderNo);
        Order order = orderService.getOne(queryWrapper);
        return R.success().data("order", order);
    }


    /* *
     * 根据课程id和用户id判断该课程是否被购买
     * @param memberId
     * @param courseId
     * @return
     */
    @GetMapping("/isBuyCourse/{memberId}/{courseId}")
    public boolean isBuyCourse(@PathVariable("memberId") String memberId, @PathVariable("courseId") String courseId) {
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("member_id", memberId);
        wrapper.eq("course_id", courseId);
        wrapper.eq("status", 1);
        //订单状态是1表示支付成功
        int count = orderService.count();
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

}

