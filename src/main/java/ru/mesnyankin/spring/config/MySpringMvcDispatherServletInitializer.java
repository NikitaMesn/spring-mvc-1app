package ru.mesnyankin.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    //возвращаем класс с конфигами
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    //все http запросы пользователя посылаем на dispetcherservlet
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
