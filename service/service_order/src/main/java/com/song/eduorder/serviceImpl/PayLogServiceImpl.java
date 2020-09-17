package com.song.eduorder.serviceImpl;

import com.song.eduorder.entity.PayLog;
import com.song.eduorder.mapper.PayLogMapper;
import com.song.eduorder.service.PayLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付日志表 服务实现类
 * </p>
 *
 * @author Song
 * @since 2020-09-17
 */
@Service
public class PayLogServiceImpl extends ServiceImpl<PayLogMapper, PayLog> implements PayLogService {

}
