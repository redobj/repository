package com.redobj.repository.core.control.analysis.spider;

import com.redobj.repository.core.constant.Constant;
import org.jsoup.nodes.Document;
import sun.applet.Main;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainSpider implements PageProcessor {
    private Site site = Site.me().
            setRetryTimes(3).
            setSleepTime(100).
            addHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
    private List<Integer> temperatureList = new ArrayList<>();
    private List<Integer> humidityList = new ArrayList<>();

    public static void run(String keyword){
        MainSpider mainSpider = new MainSpider();
         String url = Constant.SPIDER_URL + keyword + "%20仓库环境";
         Spider spider = Spider.create(mainSpider).thread(Constant.SPIDER_THREAD).addUrl(url).addPipeline(new ConsolePipeline());
         spider.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            spider.stop();
        }

        System.out.println("wendu");
        for(int i: mainSpider.getTemperatureList()){
            System.out.print(i + " ");
        }
        System.out.println("shidu");
        for(int i: mainSpider.getHumidityList()){
            System.out.println(i + " ");
        }



    }


    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().xpath("//*[@id=\"page\"]/a[10]").links().all());
        page.addTargetRequests(page.getHtml().$(".result").links().all());
        temperatureList.add(Integer.valueOf(page.getHtml().regex("\\S+\\u6e29\\u5ea6\\S+").regex("[0-9.]+[\\u2103\\u5ea6-]").regex("[0-9]+").toString()));
        humidityList.add(Integer.valueOf(page.getHtml().regex("\\S+\\u6e7f\\u5ea6\\S+").regex("[0-9.]+%").regex("[0-9]+").toString()));
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
    private Map<String,Integer> analysis(List<Integer> list) {
        // 希尔排序 算法
        for(int increment = list.size()/2 ; increment < list.size() ; increment /= 2){

        }
        return null;
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
