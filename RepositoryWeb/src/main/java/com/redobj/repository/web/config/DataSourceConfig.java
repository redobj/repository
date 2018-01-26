package com.redobj.repository.web.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.beans.PropertyVetoException;
import java.io.IOException;

@Configuration
@MapperScan("com.redobj.repository.web.dao")
@PropertySource("classpath:dbConfig.properties")
public class DataSourceConfig {
    @Value("${jdbc.jdbcUrl}")
    private String jdbcUrl;
    @Value("${jdbc.jdbcClass}")
    private String jdbcClass;
    @Value("${jdbc.jdbcUser}")
    private String jdbcUser;
    @Value("${jdbc.jdbcPwd}")
    private String jdbcPwd;

    @Bean
    public ComboPooledDataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl(jdbcUrl);
        try {
            dataSource.setDriverClass(jdbcClass);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setTestConnectionOnCheckin(false);
        dataSource.setTestConnectionOnCheckout(true);
        dataSource.setUser(jdbcUser);
        dataSource.setPassword(jdbcPwd);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(){
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource());
        try {
            bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bean;
    }

}
