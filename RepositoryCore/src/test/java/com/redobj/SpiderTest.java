package com.redobj;


import com.redobj.repository.core.control.analysis.spider.MainSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import us.codecraft.webmagic.Spider;

public class SpiderTest {




    @Test
    public void spiderTest01(){
        MainSpider.run("普洱茶");

    }




}
