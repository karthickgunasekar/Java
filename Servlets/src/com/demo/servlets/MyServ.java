package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServ extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter pw = res.getWriter();
		pw.append("HelloWorld");
	}
}
