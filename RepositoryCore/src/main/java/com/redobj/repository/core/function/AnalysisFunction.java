package com.redobj.repository.core.function;

import com.redobj.repository.core.constant.Constant;
import com.redobj.repository.core.control.analysis.spider.MainAnalysis;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

import java.util.HashMap;
import java.util.Map;

public class AnalysisFunction {


    public Map<String,Map<String,Integer>> analysisRun(String keyword, int runningTime){
        String url = Constant.SPIDER_URL + keyword + "%20仓库环境";
        MainAnalysis analysisTool = new MainAnalysis();
        Spider spider = Spider.create(analysisTool).thread(Constant.SPIDER_THREAD).addUrl(url).addPipeline(new ConsolePipeline());
        spider.start();

        try {
            Thread.sleep(runningTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spider.stop();
        }

        Map<String,Map<String,Integer>> result = new HashMap<String,Map<String,Integer>>();
        result.put("temperature", analysisTool.analysis(analysisTool.getTemperatureList()));
        result.put("humidity", analysisTool.analysis(analysisTool.getHumidityList()));

        return result;
    }

    public Map<String,Map<String,Integer>> analysisRun(String keyword){
        String url = Constant.SPIDER_URL + keyword + "%20仓库环境";
        MainAnalysis analysisTool = new MainAnalysis();
        Spider spider = Spider.create(analysisTool).thread(Constant.SPIDER_THREAD).addUrl(url).addPipeline(new ConsolePipeline());
        spider.start();

        try {
            Thread.sleep(Constant.SPIDER_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spider.stop();
        }

        Map<String,Map<String,Integer>> result = new HashMap<String,Map<String,Integer>>();
        result.put("temperature", analysisTool.analysis(analysisTool.getTemperatureList()));
        result.put("humidity", analysisTool.analysis(analysisTool.getHumidityList()));

        return result;
    }
}
