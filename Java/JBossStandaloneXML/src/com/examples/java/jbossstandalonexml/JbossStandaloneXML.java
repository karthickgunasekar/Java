package com.examples.java.jbossstandalonexml;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class JbossStandaloneXML extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)  
			throws ServletException,IOException  
			{  
		System.out.println("Heelo");
			res.setContentType("text/html");  
			PrintWriter pw=res.getWriter();  
			  
			//creating ServletContext object  
			ServletContext context=getServletContext();  
			System.out.println(context.getServerInfo());
			  
			//Getting the value of the initialization parameter and printing it  
			String driverName=context.getInitParameter("dname");  
			pw.println("driver name is="+driverName);  
			try {
				DataSource ds = (DataSource) InitialContext.doLookup("java:jboss/datasources/ExampleDS");
				PreparedStatement rs = ds.getConnection().prepareStatement("SELECT PRODUCTCODE FROM MOP WHERE MOP = 'USD_RTP'");
				ResultSet rss = rs.executeQuery();
				while(rss.next()){
					System.out.println("Inside loop");
				System.out.println(rss.getString("PRODUCTCODE"));
				}
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			try {
//				Context initialContext = new InitialContext();
//				Context envContext  = (Context)initialContext.lookup("java:jboss/datasources/ExampleDS");
//				DataSource ds = (DataSource)envContext.lookup("ExampleDS");
//				Connection conn = ds.getConnection();
//				System.out.println(conn.getMetaData().getDriverName());
//			} catch (NamingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			  
			pw.close();  
			  
			}  
}
