package com.song.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: guli_parent
 * @description 统一返回结果
 * @author: swq
 * @create: 2020-08-30 13:19
 **/
@Data
public class R {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<>();

    // 对象私有化
    private R() {
    }

    // 成功的方法
    public static R success() {
        R result = new R();
        result.setSuccess(Boolean.TRUE);
        result.setCode(ResultCode.SUCCESS);
        result.setMessage("成功");
        return result;
    }

    // 失败的方法
    public static R error() {
        R result = new R();
        result.setSuccess(Boolean.FALSE);
        result.setCode(ResultCode.ERROR);
        result.setMessage("失败");
        return result;
    }

    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    public R data(Map<String, Object> dataMap) {
        this.setData(dataMap);
        return this;
    }

    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

}
