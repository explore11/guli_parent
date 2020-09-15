package com.song.eduservice.controller;


import com.song.commonutils.R;
import com.song.eduservice.entity.UcenterMember;
import com.song.eduservice.service.UcenterMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}

