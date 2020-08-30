package com.song.servicebase.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: guli_parent
 * @description //TODO
 * @author: swq
 * @create: 2020-08-30 21:47
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuLiException extends RuntimeException {
    private Integer code;
    private String msg;
}
