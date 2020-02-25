package com.microservice.discovery.config;

import java.util.EnumSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.DispatcherType;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.core.env.Environment;

public class WebApplicationEnvProfile implements ServletContextInitializer {

	private final Environment env;

	
	public WebApplicationEnvProfile(Environment env) {
		this.env=env;
	}
	
	  @Override
	    public void onStartup(ServletContext servletContext) throws ServletException {
	        if (env.getActiveProfiles().length != 0) {
	          System.out.println("Web application configuration, using profiles: {}"+(Object[]) env.getActiveProfiles());
	        }
	        EnumSet<DispatcherType> disps = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ASYNC);
	    }
	
}
