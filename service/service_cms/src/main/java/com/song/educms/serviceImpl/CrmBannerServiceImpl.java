package com.song.educms.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.song.educms.entity.CrmBanner;
import com.song.educms.mapper.CrmBannerMapper;
import com.song.educms.service.CrmBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author Song
 * @since 2020-09-15
 */
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {

    @Override
    public List<CrmBanner> queryAllBanner() {
        QueryWrapper<CrmBanner> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("limit 2");
        List<CrmBanner> banners = baseMapper.selectList(queryWrapper);
        return banners;
    }
}
