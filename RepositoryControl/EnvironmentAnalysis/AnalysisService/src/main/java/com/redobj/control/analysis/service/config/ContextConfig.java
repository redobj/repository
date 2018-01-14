package com.redobj.control.analysis.service.config;

import com.redobj.control.analysis.core.call.EnvironmentCall;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfig {
    @Bean
    public EnvironmentCall environmentCall(){
        return new EnvironmentCall();
    }
}
