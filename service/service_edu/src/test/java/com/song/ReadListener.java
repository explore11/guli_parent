package com.song;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/* *
 * @program: guli_parent
 * @description //TODO
 * @author: swq
 * @create: 2020-09-12 11:23
 **/
public class ReadListener extends AnalysisEventListener<TestData> {

    @Override
    public void invoke(TestData testData, AnalysisContext analysisContext) {
        System.out.println("*********" + testData);
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头" + headMap);
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
