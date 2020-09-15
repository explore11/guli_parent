package com.song.eduservice.service;

import com.song.eduservice.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.song.eduservice.entity.vo.RegisterVO;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author Song
 * @since 2020-09-15
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    String login(UcenterMember ucenterMember);

    boolean register(RegisterVO registerVO);

    UcenterMember getMemberInfoByToken(HttpServletRequest request);

    void test();
}
