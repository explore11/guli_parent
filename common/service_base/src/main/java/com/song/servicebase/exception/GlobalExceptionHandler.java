package com.song.servicebase.exception;

import com.song.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: guli_parent
 * @description 全局异常处理类
 * @author: swq
 * @create: 2020-08-30 21:22
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message("请求失败,进入了错误页面");
    }



    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("ArithmeticException  请求失败,进入了错误页面");
    }


    @ExceptionHandler(GuLiException.class)
    @ResponseBody
    public R error(GuLiException e) {
        e.printStackTrace();
        log.error(e.getMsg());
        return R.error().message("GuLiException  请求失败,进入了错误页面");
    }
}
