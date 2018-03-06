package com.redobj.repository.web.config;

import com.redobj.repository.web.timer.AnalysisResultSave;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

@Configuration
@Import(DataSourceConfig.class)
@ComponentScan(value = "com.redobj.repository.web",excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class))
public class SpringContextConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public AnalysisResultSave analysisResultSave(){
        return new AnalysisResultSave();
    }


}
