package com.examples.java.basicrest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/com.examples.java.basicrest/app/v1/user")
public class RestServer {
	
	private final String scheme = "http";
	private final String host = "10.0.3.129";
	private final String port = "8081";
	private final String basePath = "com.examples.java.basicrest/app";
	private final String userName = "admin";
	private final String password = "admin@123";
	
	@Path("/getusers")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getUsers(){
		return "admin";
	}
	
	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON_PATCH_JSON)
	public void loginUser(String value){
		
	}

}
