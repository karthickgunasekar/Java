package com.examples.java.basicrest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;



import com.sun.net.httpserver.HttpServer;



public class RestClient {
	
	
	public static void main(String[] args) {
		
		try {
			HttpServer httpServer = HttpServer.create();
			httpServer.createContext("/com.examples.java.basicrest/app/v1/user");
			InetSocketAddress isa = InetSocketAddress.createUnresolved(InetAddress.getLocalHost().getHostName(), 8082);
			System.out.println(isa.isUnresolved());
			httpServer.bind(isa, 0);
			httpServer.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		final Client client = ClientBuilder.newClient();
		client.property("foo", "bar").register(RestClient.class).register(RestServer.class);
		WebTarget wt = client.target("http://10.0.3.129:8081/com.examples.java.basicrest/app/v1/user/getusers");
		System.out.println("hi "+wt.request().get(Response.class));
	}

}
