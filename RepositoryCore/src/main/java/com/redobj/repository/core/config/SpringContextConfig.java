package com.redobj.repository.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DataSourceConfig.class)
@ComponentScan(basePackages = "com.redobj.repository.core")
public class SpringContextConfig {

}