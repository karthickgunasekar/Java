package com.quartz;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class ApacheCamelQuartz extends QuartzScheduler{

	public static void main(String[] args) throws Exception {
	ApacheCamelQuartz acq = new ApacheCamelQuartz();
	CamelContext ctx = new DefaultCamelContext();
	ctx.addRoutes(acq);
	ctx.start();
	ctx.setTracing(true);
	Thread.sleep(100000);
	}

}

class QuartzScheduler extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("quartz2://myQuartz?cron=0 14 8,11,15,22 ? * MON,TUE,WED,THU,FRI *").to("file:input1?fileName=a.txt");
	//from("file:input").to("file:output");
	}
	
}