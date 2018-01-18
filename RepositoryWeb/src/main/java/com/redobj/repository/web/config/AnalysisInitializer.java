package com.redobj.repository.web.config;

import com.redobj.repository.core.config.SpringContextConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AnalysisInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ContextConfig.class, SpringContextConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{DispatcherConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
