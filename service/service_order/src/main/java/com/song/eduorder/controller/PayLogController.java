package com.song.eduorder.controller;


import com.song.commonutils.R;
import com.song.eduorder.service.PayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 支付日志表 前端控制器
 * </p>
 *
 * @author Song
 * @since 2020-09-17
 */
@RestController
@RequestMapping("/eduOrder/payLog")
@CrossOrigin
public class PayLogController {

    @Autowired
    private PayLogService payLogService;

    /* *
     * 生成支付的二维码
     * @param orderNo
     * @return
     */
    @GetMapping("/createNativeCode/{orderNo}")
    public R createNativeCode(@PathVariable("orderNo") String orderNo) {
        Map<String, Object> map = payLogService.createNativeCode(orderNo);
        System.out.println("###### 生成支付的二维码map " + map);
        return R.success().data(map);
    }

    /* *
     * 获取订单支付状态
     * @param orderNo
     * @return
     */
    @GetMapping("/queryPayStatus/{orderNo}")
    public R queryPayStatus(@PathVariable("orderNo") String orderNo) {

        //调用查询接口4
        Map<String, String> map = payLogService.queryPayStatus(orderNo);
        System.out.println("*********** 获取订单支付状态 map " + map);
        if (map == null) {//出错
            return R.error().message("支付出错");
        }
        if (map.get("trade_state").equals("SUCCESS")) {//如果成功
            //更改订单状态
            payLogService.updateOrderStatus(map);
            return R.success().message("支付成功");
        }
        return R.success().code(25000).message("支付中");
    }
}

