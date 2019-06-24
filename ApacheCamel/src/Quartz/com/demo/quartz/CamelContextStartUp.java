package Quartz.com.demo.quartz;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelContextStartUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CamelContext cc = new DefaultCamelContext();
		DailyAndMonthlyQuartzRoutes dmqr = new DailyAndMonthlyQuartzRoutes();
		try {
			cc.addRoutes(dmqr.rb1);
			//cc.addRoutes(dmqr.rb2);
			cc.start();
			Thread.currentThread().sleep(100000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
