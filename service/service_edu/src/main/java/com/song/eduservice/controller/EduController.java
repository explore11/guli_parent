package com.song.eduservice.controller;

import com.song.commonutils.R;
import org.springframework.web.bind.annotation.*;

/* *
 * @program: guli_parent
 * @description:
 * @author: swq
 * @create: 2020-09-11 15:54
 **/
@RestController
@RequestMapping("/eduService/user")
@CrossOrigin
public class EduController {

    @PostMapping("/login")
    public R login() {
        return R.success().data("token", "admin");
    }

    @GetMapping("/info")
    public R info() {
        return R.success().data("roles", "admin").data("name", "admin").data("avatar", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1106137350,568539011&fm=26&gp=0.jpg");
    }

}
