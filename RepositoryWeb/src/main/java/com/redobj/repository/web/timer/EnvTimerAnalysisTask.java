package com.redobj.repository.web.timer;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnvTimerAnalysisTask implements InitializingBean {
    @Autowired
    WaitDispatch waitDispatch;

    @Override
    public void afterPropertiesSet() throws Exception {
        waitDispatch.task();
    }
}
