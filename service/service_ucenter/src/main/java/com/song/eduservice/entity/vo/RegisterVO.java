package com.song.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-15 23:15
 **/
@Data
public class RegisterVO {
    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "验证码")
    private String code;
}
