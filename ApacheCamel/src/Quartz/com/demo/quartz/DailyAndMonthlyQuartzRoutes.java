package Quartz.com.demo.quartz;

import org.apache.camel.builder.RouteBuilder;

public class DailyAndMonthlyQuartzRoutes {
	
	RouteBuilder rb1 =new RouteBuilder() {
		
		@Override
		public void configure() throws Exception {
			// TODO Auto-generated method stub
			from("quartz2://monthly2?cron=30 03 12 * * ?").setHeader("frequency").simple("daily123").to("volante:VLReportsGenerate");
		}
	};
	
	RouteBuilder rb2 = new RouteBuilder() {
		
		@Override
		public void configure() throws Exception {
			// TODO Auto-generated method stub
			from("quartz2://monthly?cron=30 03 12 L * ?").setHeader("frequency").simple("monthly").to("volante:VLReportsGenerate");
		}
	};
}
