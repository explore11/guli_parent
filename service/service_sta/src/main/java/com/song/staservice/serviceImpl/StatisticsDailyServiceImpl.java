package com.song.staservice.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.song.staservice.entity.StatisticsDaily;
import com.song.staservice.mapper.StatisticsDailyMapper;
import com.song.staservice.rmt.UcenterRmt;
import com.song.staservice.service.StatisticsDailyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 网站统计日数据 服务实现类
 * </p>
 *
 * @author Song
 * @since 2020-09-18
 */
@Service
public class StatisticsDailyServiceImpl extends ServiceImpl<StatisticsDailyMapper, StatisticsDaily> implements StatisticsDailyService {
    @Resource
    private UcenterRmt ucenterRmt;

    @Override
    public void createStatisticsByDay(String day) {
        //删除已存在的统计对象
        QueryWrapper<StatisticsDaily> dayQueryWrapper = new QueryWrapper<>();
        dayQueryWrapper.eq("date_calculated", day);
        baseMapper.delete(dayQueryWrapper);
        //获取统计信息
        Integer registerNum = (Integer) ucenterRmt.registerCount(day).getData().get("countRegister");
        // 随机生成
        Integer loginNum = RandomUtils.nextInt(100, 200);
        // 随机生成
        Integer videoViewNum = RandomUtils.nextInt(100, 200);
        // 随机生成
        Integer courseNum = RandomUtils.nextInt(100, 200);

        // 创建统计对象
        StatisticsDaily daily = new StatisticsDaily();
        daily.setRegisterNum(registerNum);
        daily.setLoginNum(loginNum);
        daily.setVideoViewNum(videoViewNum);
        daily.setCourseNum(courseNum);
        daily.setDateCalculated(day);
        baseMapper.insert(daily);
    }
}
