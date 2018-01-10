package com.volantetech.services.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.commons.io.IOUtils;

import com.volantetech.volante.services.camel.utilites.ServletContextAccessor;

/**
 * Servlet implementation class DownloadExcel
 */
@WebServlet("/DownloadExcel")
public class DownloadExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadExcel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String folioId = paramHttpServletRequest.getParameter("FolioID");
		String fileContent = "";

		ResultSet rs = null;
		try {
			// step1 load the driver class

			// step2 create the connection object
			Clob clob = null;
			Properties prop = new Properties();
			ServletContext servletContext = ServletContextAccessor.getCustomServletContext();

			prop.load(servletContext.getResourceAsStream("/WEB-INF/classes/data-sources.xml"));

			System.out.println(servletContext.getServerInfo());
			ResultSet resultSet = null;
			DataSource dataSource = null;

			if (servletContext.getServerInfo().startsWith("Apache Tomcat")) {
			/*	String connection_driver = prop.getProperty("connection-driver").replace("\"", "");
				String url = prop.getProperty("url").replace("\"", "");
				String username = prop.getProperty("username").replace("\"", "");
				String password = prop.getProperty("password").replace("\"", "");

				Class.forName(connection_driver);
				Connection con = DriverManager.getConnection(url, username, password);

				// step3 create the statement object
				Statement stmt = con.createStatement();

				// step4 execute query
				rs = stmt.executeQuery("select RETURNSTACK1 from REPORTLOG where FOLIOID = '" + folioId + "'");*/
				String server_location = prop.getProperty("data-source").replace("\"", "");
				dataSource = (DataSource) InitialContext.doLookup(server_location);
/*				while (rs.next()) {

					clob = rs.getClob(1);
				}
				System.out.println("after rs value is null ");
*/				/*
				 * if(clob!=null){ fileContent = clob.getSubString(1,
				 * (int)clob.length()); }
				 */
				// step5 close the connection object
				// System.out.println(fileContent);
//				con.close();
			} else if (servletContext.getServerInfo().startsWith("JBoss Web")) {
				String server_location = prop.getProperty("server-location").replace("\"", "");
				dataSource = (DataSource) InitialContext.doLookup(server_location);
				
			}
			PreparedStatement preparedStatement = dataSource.getConnection()
					.prepareStatement("select RETURNSTACK1 from REPORTLOG where FOLIOID = '" + folioId + "'");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				clob = resultSet.getClob(1);
			}
			preparedStatement.close();
			if (clob != null) {
				fileContent = clob.getSubString(1, (int) clob.length());
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		paramHttpServletResponse.setContentType("application/vnd.ms-excel");
		paramHttpServletResponse.setDateHeader("Expires", 0L);

		paramHttpServletResponse.addHeader("Content-Disposition", "attachment; filename=AllPayments.xls");
		OutputStream os = paramHttpServletResponse.getOutputStream();
		base64DecodeAndCopyStream(IOUtils.toInputStream(fileContent), os, false);

		os.flush();
		os.close();

	}

	private void copyStream(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean)
			throws IOException {
		byte[] arrayOfByte = new byte[256];
		int i = 0;
		while ((i = paramInputStream.read(arrayOfByte)) != -1) {
			paramOutputStream.write(arrayOfByte, 0, i);
		}
		if (paramBoolean)
			paramOutputStream.close();
	}

	private void base64DecodeAndCopyStream(InputStream paramInputStream, OutputStream paramOutputStream,
			boolean paramBoolean) throws IOException {
		Base64InputStream localBase64InputStream = new Base64InputStream(paramInputStream);
		copyStream(localBase64InputStream, paramOutputStream, paramBoolean);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
