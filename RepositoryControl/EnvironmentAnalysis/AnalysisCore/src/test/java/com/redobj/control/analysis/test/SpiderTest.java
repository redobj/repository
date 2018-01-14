package com.redobj.control.analysis.test;

import com.redobj.control.analysis.core.bean.Environment;
import com.redobj.control.analysis.core.bean.Goods;
import com.redobj.repository.coreroot.bean.Msg;
import com.redobj.control.analysis.core.config.SpringContextConfig;
import com.redobj.control.analysis.core.service.EnvironmentService;
import com.redobj.control.analysis.core.service.GoodsService;
import com.redobj.control.analysis.core.service.WaitService;
import com.redobj.control.analysis.core.spider.HumiditySpider;
import com.redobj.control.analysis.core.spider.TemperatureSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import us.codecraft.webmagic.*;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

import java.util.Date;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfig.class)
public class SpiderTest {
    @Autowired
    TemperatureSpider temperatureSpider;
    @Autowired
    HumiditySpider humiditySpider;
    @Autowired
    GoodsService goodsService;
    @Autowired
    WaitService waitService;
    @Autowired
    EnvironmentService environmentService;


    @Test
    public void spiderTest1() throws InterruptedException {
//        System.out.println(temperatureSpider.getCompleteUrl());
//        Spider spider = Spider.create(temperatureSpider).addUrl(temperatureSpider.getCompleteUrl())
//                .addPipeline(null).thread(temperatureSpider.getThreadNum());
//        spider.runAsync();
//        Thread.sleep(temperatureSpider.getTime());
//        spider.stop();
//        Thread.sleep(3000);
//        temperatureSpider.getResult("");


        Msg runRes = temperatureSpider.spiderRun("普洱茶");
        if(runRes.getCode()==100){
            Map<String, Object> map = runRes.getExtend();
            for (String key:map.keySet()
                    ) {
                System.out.println(key+" : "+map.get(key));
            }
        }else{
            System.out.println("Error:"+runRes.getCode()+" Msg:"+runRes.getExtend().get("msg"));
        }



//        Spider spider = Spider.create(new HumiditySpider()).addUrl("http://www.baidu.com/s?wd="+"普洱茶")
//                .addPipeline(new ConsolePipeline()).thread(10);
//        spider.start();
    }

    @Test
    public void HumidityTest(){
//        humiditySpider.spiderRun("普洱茶");
        Spider.create(humiditySpider).addPipeline(new ConsolePipeline()).addUrl("https://www.baidu.com/redobj").thread(5).run();
        Msg runRes = humiditySpider.spiderRun("普洱茶") ;
        System.out.println(humiditySpider.getCompleteUrl());
        if(runRes.getCode()==100){
            Map<String, Object> map = runRes.getExtend();
            for (String key:map.keySet()
                    ) {
                System.out.println(key+" : "+map.get(key));
            }
        }else{
            System.out.println("Error:"+runRes.getCode()+" Msg:"+runRes.getExtend().get("msg"));
        }
    }

    @Test
    public void spiderSaveTest(){
//        return Msg.success().add("time",time/1000).add("dataSize",res.size()).add("temperature",count/res.size());
        String goodsName = "绿茶";
        Environment environment = new Environment();
        Msg runRes = temperatureSpider.spiderRun(goodsName);
        if(runRes.getCode()==100) {
            environment.setTemperature((Double) runRes.getExtend().get("temperature"));
            environment.settDatasize((Integer) runRes.getExtend().get("dataSize"));
            environment.settDatetime(new Date());
        }

        Msg runRes2 = humiditySpider.spiderRun(goodsName) ;
        if(runRes2.getCode()==100) {
            environment.setHumidity((Double) runRes2.getExtend().get("humidity"));
            environment.sethDatasize((Integer) runRes2.getExtend().get("dataSize"));
            environment.sethDatetime(new Date());
        }

        Goods goods = goodsService.goodsByName(goodsName);
        if (goods == null){
            environmentService.environmentSetting(environment);
            goods = new Goods();
            goods.setGoodsName(goodsName);
            goods.setGoodsEnv(environment.getEnvironmentId());
            goodsService.goodsAdd(goods);
        }else{
            environment.setEnvironmentId(goods.getGoodsEnv());
            environmentService.environmentSetting(environment);
        }

    }
}
