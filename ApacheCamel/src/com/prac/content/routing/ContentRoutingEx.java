package com.prac.content.routing;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class ContentRoutingEx extends RouteBuilder implements Processor  {

	@Override
	public void process(Exchange arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("exchange");
		arg0.setProperty("frequency", "daily");
		
	}

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("configure");
		from("file:content").log("${body}").choice().when().constant("true").to("file:daily").when().simple("false").to("file:monthly").endChoice();
	}

}
