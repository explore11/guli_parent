package com.song.educms.controller;


import com.song.commonutils.R;
import com.song.educms.entity.CrmBanner;
import com.song.educms.service.CrmBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author Song
 * @since 2020-09-15
 */
@RestController
@CrossOrigin
@RequestMapping("/eduCms/crmBannerFront")
public class CrmBannerFrontController {
    @Autowired
    private CrmBannerService crmBannerService;

    /* *
     * 前台查询banner
     * @return
     */
    @GetMapping("/queryAllBanner")
    @Cacheable(key = "'selectIndexList'",value = "banner")
    public R queryAllBanner() {
        List<CrmBanner> banners = crmBannerService.queryAllBanner();
        return R.success().data("banners", banners);
    }

}

