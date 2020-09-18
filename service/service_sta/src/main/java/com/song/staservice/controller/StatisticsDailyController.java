package com.song.staservice.controller;


import com.song.commonutils.R;
import com.song.staservice.service.StatisticsDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    /* *
     * 根据类型生成图像
     * @param begin
     * @param end
     * @param type
     * @return
     */
    @GetMapping("showChart/{begin}/{end}/{type}")
    public R showChart(@PathVariable("begin") String begin, @PathVariable("end") String end, @PathVariable("type") String type) {
        Map<String, Object> map = statisticsDailyService.getChartData(begin, end, type);
        return R.success().data(map);
    }
}

