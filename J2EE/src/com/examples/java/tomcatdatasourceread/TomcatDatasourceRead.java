package com.examples.java.tomcatdatasourceread;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TomcatDatasourceRead extends HttpServlet {
	Properties prop = null;
	ServletContext servletContext = null;

	public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException {
		if (servletContext == null) {
			servletContext = httpServletRequest.getServletContext();
			this.prop = new Properties();
			prop.load(servletContext.getResourceAsStream("/WEB-INF/classes/data-sources.xml"));
			//System.out.println(prop.size());
		} else {
			this.prop = new Properties();			
			prop.load(servletContext.getResourceAsStream("/WEB-INF/classes/data-sources.xml"));
			
			//System.out.println(prop.size());
		}
		
		for(Object obj:prop.values()){
			System.out.println((String)obj);
		}
	}
}
