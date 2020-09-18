package com.song.staservice.controller;


import com.song.commonutils.R;
import com.song.staservice.service.StatisticsDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author Song
 * @since 2020-09-18
 */
@RestController
@RequestMapping("/staService/statisticsDaily")
@CrossOrigin
public class StatisticsDailyController {
    @Autowired
    private StatisticsDailyService statisticsDailyService;


    /* *
     * 添加统计数据
     * @param day
     * @return
     */
    @PostMapping("/createStatisticsByDate/{day}")
    public R createStatisticsByDate(@PathVariable String day) {
        statisticsDailyService.createStatisticsByDay(day);
        return R.success();
    }
}

