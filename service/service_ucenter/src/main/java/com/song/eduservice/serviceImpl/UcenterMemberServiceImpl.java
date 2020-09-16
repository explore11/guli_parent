package com.song.eduservice.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.song.commonutils.JwtUtils;
import com.song.commonutils.Md5Utils;
import com.song.eduservice.entity.UcenterMember;
import com.song.eduservice.entity.vo.RegisterVO;
import com.song.eduservice.mapper.UcenterMemberMapper;
import com.song.eduservice.service.UcenterMemberService;
import com.song.servicebase.exception.GuLiException;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.experimental.theories.Theories;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

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

    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

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


    @Override
    public boolean register(RegisterVO registerVO) {
        String code = registerVO.getCode();
        String mobile = registerVO.getMobile();
        String nickname = registerVO.getNickname();
        String password = registerVO.getPassword();

        if (StringUtils.isEmpty(password) || StringUtils.isEmpty(mobile)
                || StringUtils.isEmpty(nickname) || StringUtils.isEmpty(code)) {
            throw new GuLiException(20001, "注册失败");
        }
        // redis 校验验证码是否过期  校验验证码是否相同
        String codeByRedis = redisTemplate.opsForValue().get(mobile);
        if (StringUtils.isEmpty(codeByRedis) || !code.equals(codeByRedis)) {
            throw new GuLiException(20001, "验证码失效，请重新获取验证码");
        }

        // 校验手机号码
        QueryWrapper<UcenterMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile", mobile);
        Integer count = baseMapper.selectCount(queryWrapper);
        if (count == 0) {
            //进行注册
            UcenterMember ucenterMember = new UcenterMember();
            ucenterMember.setIsDisabled(false);
            ucenterMember.setNickname(nickname);
            ucenterMember.setPassword(Md5Utils.md5(password, Md5Utils.salt, 1));
            ucenterMember.setMobile(mobile);
            ucenterMember.setAvatar("http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132");
            int insert = baseMapper.insert(ucenterMember);
            return insert > 0;
        } else {
            throw new GuLiException(20001, "用户手机号已存在，请重新注册");
        }
    }


    @Override
    public UcenterMember getMemberInfoByToken(HttpServletRequest request) {
        // 获取用户id
        String id = JwtUtils.getMemberIdByJwtToken(request);
        UcenterMember member = baseMapper.selectById(id);
        if (member == null) {
            throw new GuLiException(20001, "获取用户失败");
        } else {
            return member;
        }
    }


    @Override
    public UcenterMember getOpenIdMember(String openid) {
        QueryWrapper<UcenterMember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid", openid);
        return baseMapper.selectOne(queryWrapper);
    }

}
