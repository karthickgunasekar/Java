package com.examples.java.basicrest;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Camel {
	
	public static void main(String[] args) {
		CamelContext ctxt = new DefaultCamelContext();
		ctxt.createConsumerTemplate()
		try {
			ctxt.addRoutes(new org.apache.camel.builder.RouteBuilder() {
				
				@Override
				public void configure() throws Exception {
					// TODO Auto-generated method stub
					
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
