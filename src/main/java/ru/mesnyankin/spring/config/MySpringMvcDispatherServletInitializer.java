package ru.mesnyankin.spring.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

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


    //добавил фильтр для thymeleaf по перенапрке post запроса на patch
    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        registerHiddenFieldFilter(aServletContext);

    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*");
    }
}
