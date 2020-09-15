package com.song.educms.service;

import com.song.educms.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author Song
 * @since 2020-09-15
 */
public interface CrmBannerService extends IService<CrmBanner> {

    List<CrmBanner> queryAllBanner();
}
