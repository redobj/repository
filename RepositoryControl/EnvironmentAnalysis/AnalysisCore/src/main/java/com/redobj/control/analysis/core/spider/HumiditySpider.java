package com.redobj.control.analysis.core.spider;

import com.redobj.repository.coreroot.bean.Msg;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@PropertySource("classpath:spiderConfig.properties")
public class HumiditySpider implements PageProcessor {
    @Autowired
    private Site site;
    @Value("${spider.time}")
    private int time;
    @Value("${spider.thread}")
    private int threadNum;
    @Value("${spider.url}")
    private String url;


    private String completeUrl;
    private String keyword;
    private List<Double> res = new ArrayList<Double>();

    public void process(Page page) {
//        page.putField("a",page.getHtml().xpath("//*[@id=\"page\"]/a[10]").links().all());
        page.addTargetRequests(page.getHtml().xpath("//*[@id=\"page\"]/a[10]").links().all());
        page.addTargetRequests(page.getHtml().$(".result").links().all());
        analysis(page.getHtml().getDocument());
    }

    private void analysis(Document document) {
        String hum_regex = "^\\S+\\u6e7f\\u5ea6\\S+$";
        String numRegex = "[0-9.]+%";
        Elements elements = document.getAllElements();
        Pattern pattern = Pattern.compile(numRegex);
        Matcher matcher;
        Double temp;
        for (Element element : elements) {
            if (element.text().matches(hum_regex)) {
                matcher = pattern.matcher(element.text());
                while (matcher.find()) {
                    temp = Double.parseDouble(matcher.group().replace("%", ""));
                        System.out.println(temp);
                        res.add(temp);
                }
            }
        }
    }

    private void setKeyword(String keyword) {
//        this.keyword = keyword + "%20最佳仓库湿度";
        this.keyword = keyword + "%20仓库环境";
        this.completeUrl = this.url + this.keyword;
        res.clear();
    }

    private Msg getResult() {
        Double count = 0.0;
        if (res.size()==0){
            return Msg.fail().add("msg","没有获取到数据，请等待数据源更新");
        }
        for (Double result : res) {
            count+=result;
        }
        Double avg = count/res.size();
        System.out.println("-----------------------------");
        System.out.println("去除前总数:"+count);
        System.out.println("去除前容量："+res.size());
        System.out.println("去除前平均值："+avg);
        count = 0.0;
        Double temp;
        for (int i = 0; i < res.size(); i++) {
            temp = res.get(i);
            if(temp+20<avg||temp-20>avg){
                res.remove(i);
                continue;
            }else{
                count+=temp;
            }
        }
        avg = count/res.size();
        System.out.println("-----------------------------");
        System.out.println("去除后总数:"+count);
        System.out.println("去除后容量："+res.size());
        System.out.println("去除后平均值："+avg);

        System.out.println("--------- "+keyword+" 湿度获取完毕---------");
        System.out.println("用时 "+time/1000 +"s");
        System.out.println("有效数据" + res.size() + "条");
        System.out.println("最佳湿度 " + avg +"%");
        return Msg.success().add("time", time / 1000).add("dataSize", res.size()).add("humidity", avg);
    }

    public Site getSite() {
        return site;
    }

    private int getTime() {
        return time;
    }

    private int getThreadNum() {
        return threadNum;
    }

    public String getCompleteUrl() {
        return completeUrl;
    }

    public Msg spiderRun(String goodsname) {
        this.setKeyword(goodsname);
        Spider spider = Spider.create(this).addUrl(this.getCompleteUrl())
                        .addPipeline(null).thread(this.getThreadNum());
        spider.start();
        System.out.println("---------系统正在获取 " + goodsname + " 的最佳保存湿度，请等待约 " + (this.getTime()) / 1000 + " s---------");
        try {
            Thread.sleep(this.getTime());
            spider.stop();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            spider.close();
        }

        return this.getResult();
    }

}
