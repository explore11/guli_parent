package com.song.staservice.schedule;

import com.song.staservice.service.StatisticsDailyService;
import com.song.staservice.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.util.Date;

/* *
 * @program: guli_parent
 * @description 定时
 * @author: swq
 * @create: 2020-09-18 21:22
 **/
@Component
public class ScheduleTask {
    @Autowired
    private StatisticsDailyService statisticsDailyService;

    @Scheduled(cron = "0 0 1 * * ?")
    public void task1() {
        //获取上一天的日期
        String day = DateUtil.formatDate(DateUtil.addDays(new Date(), -1));
        statisticsDailyService.createStatisticsByDay(day);
    }
}
