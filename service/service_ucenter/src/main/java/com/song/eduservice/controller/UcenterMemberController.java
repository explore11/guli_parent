package com.song.eduservice.controller;


import com.song.commonutils.R;
import com.song.eduservice.entity.UcenterMember;
import com.song.eduservice.entity.vo.RegisterVO;
import com.song.eduservice.service.UcenterMemberService;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author Song
 * @since 2020-09-15
 */
@RestController
@CrossOrigin
@RequestMapping("/eduUcenter/uCenterMember")
public class UcenterMemberController {

    @Autowired
    private UcenterMemberService ucenterMemberService;


    /* *
     * 登录
     * @param ucenterMember
     * @return
     */
    @PostMapping("/login")
    public R login(@RequestBody UcenterMember ucenterMember) {
        String token = ucenterMemberService.login(ucenterMember);
        return R.success().data("token", token);
    }

    /* *
     * 用户注册
     * @param registerVO
     * @return
     */
    @PostMapping("/register")
    public R register(@RequestBody RegisterVO registerVO) {
        boolean flag = ucenterMemberService.register(registerVO);
        if (flag) {
            return R.success();
        } else {
            return R.error();
        }
    }

    /* *
     * 根据token获取用户信息
     * @param request
     * @return
     */
    @GetMapping("/getMemberInfoByToken")
    public R getMemberInfoByToken(HttpServletRequest request) {
        UcenterMember ucenterMember = ucenterMemberService.getMemberInfoByToken(request);
        return R.success().data("ucenterMember", ucenterMember);
    }



}

