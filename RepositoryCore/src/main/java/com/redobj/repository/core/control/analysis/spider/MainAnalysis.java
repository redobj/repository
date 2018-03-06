package com.redobj.repository.core.control.analysis.spider;

import com.redobj.repository.core.constant.Constant;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.*;


public class MainAnalysis implements PageProcessor {
    private Site site = Site.me().
            setRetryTimes(3).
            setSleepTime(100).
            addHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
    private List<Integer> temperatureList = new LinkedList<>();
    private List<Integer> humidityList =new LinkedList<>();



    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().xpath("//*[@id=\"page\"]/a[10]").links().all());
        page.addTargetRequests(page.getHtml().$(".result").links().all());
        String tempTemperature = page.getHtml().regex("\\S+\\u6e29\\u5ea6\\S+").regex("[0-9.]+[\\u2103\\u5ea6-]").regex("[0-9]+").toString();
        String tempHumidity = page.getHtml().regex("\\S+\\u6e7f\\u5ea6\\S+").regex("[0-9.]+%").regex("[0-9]+").toString();
        if(tempTemperature != null){
            temperatureList.add(Integer.valueOf(tempTemperature));
        }
        if(tempHumidity != null){
            humidityList.add(Integer.valueOf(tempHumidity));
        }

    }


    @Override
    public Site getSite() {
        return site;
    }


    /**
     * 有效性分析
     * @param list 待分析数据集
     * @return 分析结果
     */
    public Map<String,Integer> analysis(List<Integer> list) {
        if(list == null || list.size() < Constant.DATA_CUT ){
            System.out.println("List is null.");
            return null;
        }

        //中位数
        int mid ;
        //平均数
        int avg ;
        Map<String,Integer> result = new HashMap<>();
        int count = 0;

        // 希尔排序 算法
        for(int increment = list.size()/2 ; increment > 0 ; increment = increment / 2){
            for(int i = increment; i < list.size();i++){
                int temp = list.get(i);
                int j;
                for(j = i - increment;j >= 0;j = j - increment){
                    if(temp<list.get(j)){
                        list.set(j+increment,list.get(j));
                    }
                    else {
                        break;
                    }
                }

                list.set(j+increment,temp) ;
            }
        }

        //数据切割
        List<Integer> cpList = list;
        list = new ArrayList<>();
        int base = cpList.size() / Constant.DATA_CUT;
        int temp = 0;
        for(int i = base;i<base<<1;i++){
            temp = cpList.get(i);
            list.add(temp);
            count += temp;
        }

        mid = list.get(list.size()/2);
        avg = count / list.size();

        result.put("size",list.size());
        result.put("result",(mid+avg)>>1);

        return result;
    }



    public List<Integer> getTemperatureList() {
        return temperatureList;
    }

    public List<Integer> getHumidityList() {
        return humidityList;
    }


    public void setTemperatureList(List<Integer> temperatureList) {
        this.temperatureList = temperatureList;
    }

    public void setHumidityList(List<Integer> humidityList) {
        this.humidityList = humidityList;
    }

}
