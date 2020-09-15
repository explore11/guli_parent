package com.song.educms.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.song.commonutils.R;
import com.song.educms.entity.CrmBanner;
import com.song.educms.service.CrmBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/eduCms/crmBannerAdmin")
public class CrmBannerAdminController {
    @Autowired
    private CrmBannerService crmBannerService;

    /* *
     *  分页查询
     * @param currentPage
     * @param limit
     * @return
     */
    @GetMapping("/getAllBannerByPage/{currentPage}/{limit}")
    public R getAllBannerByPage(@PathVariable("currentPage") long currentPage,
                                @PathVariable("limit") long limit) {

        Page<CrmBanner> crmBannerList = new Page<>(currentPage, limit);
        crmBannerService.page(crmBannerList);
        return R.success().data("crmBannerList", crmBannerList);
    }

    /* *
     * 保存banner
     * @param crmBanner
     * @return
     */
    @PostMapping("/saveBanner")
    public R saveBanner(@RequestBody CrmBanner crmBanner) {
        crmBannerService.save(crmBanner);
        return R.success();
    }

    /* *
     * 查询banner
     * @param bannerId
     * @return
     */
    @GetMapping("/queryBanner/{bannerId}")
    public R queryBanner(@PathVariable("bannerId") String bannerId) {
        CrmBanner banner = crmBannerService.getById(bannerId);
        return R.success().data("banner", banner);
    }

    /* *
     * 删除banner
     * @param bannerId
     * @return
     */
    @DeleteMapping("/deleteBanner/{bannerId}")
    public R deleteBanner(@PathVariable("bannerId") String bannerId) {
        boolean flag = crmBannerService.removeById(bannerId);
        if (flag) {
            return R.success();
        } else {
            return R.error();
        }
    }


}

