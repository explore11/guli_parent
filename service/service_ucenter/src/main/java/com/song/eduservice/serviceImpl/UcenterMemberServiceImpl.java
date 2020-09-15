package com.song.eduservice.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.song.commonutils.JwtUtils;
import com.song.commonutils.Md5Utils;
import com.song.eduservice.entity.UcenterMember;
import com.song.eduservice.mapper.UcenterMemberMapper;
import com.song.eduservice.service.UcenterMemberService;
import com.song.servicebase.exception.GuLiException;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.experimental.theories.Theories;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author Song
 * @since 2020-09-15
 */
@Service
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {


    @Override
    public String login(UcenterMember ucenterMember) {
        String password = ucenterMember.getPassword();
        String mobile = ucenterMember.getMobile();

        if (StringUtils.isEmpty(password) || StringUtils.isEmpty(mobile)) {
            throw new GuLiException(20001, "用户名或者密码为空");
        }
        // 校验手机号格式 ....

        // 去数据库中查询
        QueryWrapper<UcenterMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile", mobile);
        UcenterMember member = baseMapper.selectOne(queryWrapper);

        // 判断该用户是否被禁用
        Boolean isDisabled = member.getIsDisabled();

        if (isDisabled) {
            throw new GuLiException(20001, "该用户已经被禁用");
        }

        //判断密码是否相同
        if (Md5Utils.md5(password, Md5Utils.salt, 1).equals(member.getPassword())) {
            // 相同则返回token
            return JwtUtils.getJwtToken(member.getId(), member.getNickname());
        } else {
            throw new GuLiException(20001, "账号或者密码错误,登录失败");
        }
    }
}
