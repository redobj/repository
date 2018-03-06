package com.redobj;


import com.redobj.repository.core.control.analysis.spider.MainAnalysis;
import com.redobj.repository.core.function.AnalysisFunction;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SpiderTest {




    @Test
    public void spiderTest01(){
        Map<String,Map<String,Integer>> result =
                new AnalysisFunction().analysisRun("铁观音",10000);
        if(result.get("temperature") != null){
            System.out.println("铁观音最佳温度："+result.get("temperature").get("result")+" 数据量："+result.get("temperature").get("size"));
        }if(result.get("humidity") != null){
            System.out.println("铁观音最佳湿度"+result.get("humidity").get("result")+" 数据量："+result.get("humidity").get("size"));
        }
    }

    @Test
    public void spiderTest02(){
        MainAnalysis main = new MainAnalysis();
        Integer[] a = {};
        List<Integer> list = Arrays.asList(a);
         main.analysis(list);


    }




}
