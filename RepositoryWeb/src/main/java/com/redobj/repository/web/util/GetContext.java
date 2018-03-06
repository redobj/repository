package com.redobj.repository.web.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class GetContext implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        GetContext.context = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return context;
    }

    public static <T> T getBean(String name,Class c) throws BeansException {
        Object bean = context.getBean(name);
        if(c.isInstance(bean)){
            return (T)bean;
        }else{
            return null;
        }

    }


}
