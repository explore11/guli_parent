package com.song;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: guli_parent
 * @description //TODO
 * @author: swq
 * @create: 2020-09-12 10:47
 **/
public class TestExcel {
    public static void main(String[] args) {

//        String fileName = "D:\\student.xlsx";
//        List<TestData> dataList = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            TestData data = new TestData();
//            data.setStudentNum(i);
//            data.setStudentName("lucy" + i);
//            dataList.add(data);
//        }
//        EasyExcel.write(fileName,TestData.class).sheet("学生列表").doWrite(dataList);

        String fileName = "D:\\student.xlsx";

        EasyExcel.read(fileName,TestData.class,new ReadListener()).sheet().doRead();

    }
}
