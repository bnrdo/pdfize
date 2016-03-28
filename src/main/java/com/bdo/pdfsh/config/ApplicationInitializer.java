package com.bdo.pdfsh.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {DispatcherServeltConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String [] {"*.do"};
    	/*return new String [] {"/"};*/
    }

}
