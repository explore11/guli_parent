package com.song;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/* *
 * @program: guli_parent
 * @description //TODO
 * @author: swq
 * @create: 2020-09-12 10:54
 **/
@Data
public class TestData {
    // 设置表头名称
    @ExcelProperty(value = "学生编号", index = 0)
    private Integer studentNum;
    @ExcelProperty(value = "学生名称", index = 1)
    private String studentName;


}
