package com.harshit.web;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {SpringMVCConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		// upload temp file will put here
		File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));

		 // register a MultipartConfigElement
		MultipartConfigElement multipartConfigElement =
		new MultipartConfigElement(uploadDirectory.getAbsolutePath());
		 registration.setMultipartConfig(multipartConfigElement);
	}

}
