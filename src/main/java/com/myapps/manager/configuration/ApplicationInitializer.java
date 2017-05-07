package com.myapps.manager.configuration;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    protected Class<?>[] getRootConfigClasses()
    {
	return new Class[] { ApplicationConfiguration.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses()
    {
	return null;
    }

    @Override
    protected String[] getServletMappings()
    {
	return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters()
    {
	return new Filter[] { new CORSFilter() };
    }

    // interaface WebApplicationInitializer
    // @Override
    // public void onStartup(ServletContext servletContext) throws
    // ServletException
    // {
    // AnnotationConfigWebApplicationContext context = new
    // AnnotationConfigWebApplicationContext();
    // context.register(ApplicationConfiguration.class);
    // context.setServletContext(servletContext);
    // servletContext.addFilter(null, CORSFilter.class);
    // Dynamic dynamic = servletContext.addServlet("dispatcher", new
    // DispatcherServlet(context));
    // dynamic.addMapping("/");
    // dynamic.setLoadOnStartup(1);
    // }
}
