package com.niit.config;

import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebIntilizer extends  AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		System.out.println("customizeRegistration");
		registration.setInitParameter("dispatchOptionsRequest", "true");
		registration.setAsyncSupported(true);
	}

	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		System.out.println("Getting Resolver");
		return new Class[]{WebResolver.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		return null;
	}

	@Override
	protected String[] getServletMappings() 
	{
		return  new String[] { "/" };
	}
}