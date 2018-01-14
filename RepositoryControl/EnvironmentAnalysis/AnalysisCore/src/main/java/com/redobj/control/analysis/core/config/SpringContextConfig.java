package com.redobj.control.analysis.core.config;

import com.redobj.control.analysis.core.spider.TemperatureSpider;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;

@Configuration
@Import(DataSourceConfig.class)
@ComponentScan(basePackages = "com.redobj.control.analysis.core")
public class SpringContextConfig {

    @Bean
    public Site site(){
        return Site.me().setRetryTimes(3).setSleepTime(100).addHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
    }

}
