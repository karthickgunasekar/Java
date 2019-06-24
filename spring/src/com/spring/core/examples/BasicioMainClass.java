package com.spring.core.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicioMainClass {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("basic-spring-io.xml");
		XMLBeanInitialization xmlbi1 = ctx.getBean(XMLBeanInitialization.class);
		xmlbi1.display();
		System.out.println(xmlbi1.getColorName());
		System.out.println(xmlbi1.getColorEmun());
		//XMLBeanInitialization xmlbi2 = (XMLBeanInitialization)ctx.getBean("basicPojoClass");
	}
	
}
