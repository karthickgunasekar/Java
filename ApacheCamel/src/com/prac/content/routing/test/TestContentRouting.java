package com.prac.content.routing.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import com.prac.content.routing.ContentRoutingEx;

public class TestContentRouting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CamelContext ctx = new DefaultCamelContext();
		ContentRoutingEx cre = new ContentRoutingEx();
		try {
			ctx.addRoutes(cre);
			Map<String,String> map = new HashMap<String,String>();
			map.put("frequency", "daily");
			ctx.setProperties(map);
			ctx.start();
			ctx.setTracing(true);
			Thread.currentThread().sleep(60000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
