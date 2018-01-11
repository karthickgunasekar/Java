package com.volantetech.services.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.tplus.transform.util.log.Log;
import com.tplus.transform.runtime.log.LogFactory;
import com.volantetech.volante.services.camel.utilites.ServletContextAccessor;

@WebServlet({ "/DownloadExcel" })
public class DownloadExcel extends HttpServlet {

	protected void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
			throws ServletException, IOException {
		String[] arrayOfString = paramHttpServletRequest.getParameter("FolioID").split(",");
		String str1 = "";
		String str2 = "";
		if (arrayOfString.length > 0) {
			str2 = arrayOfString[0];
		}

		if (arrayOfString.length > 1) {
			str1 = arrayOfString[1] + ".xls";
		}
		String str3 = "";

		ResultSet localResultSet = null;
		Log log = LogFactory.getRuntimeLog();
		// log.error("logging in request");
		try {
			ServletContext localServletContext = ServletContextAccessor.getCustomServletContext();

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = null;
			NodeList nodeList = null;
			Node node = null;
			NamedNodeMap namedNodeMap = null;
			// localProperties.load(localServletContext.getResourceAsStream("/WEB-INF/classes/data-sources.xml"));
			// log.error("property loaded via context ");
			System.out.println(localServletContext.getServerInfo());
			// log.error(localServletContext.getServerInfo());
			String servNm = localServletContext.getServerInfo();
			// log.error("servNm : "+servNm);
			Clob localClob = null;
			if (servNm.startsWith("Apache Tomcat")) {
				// log.error("into Tomcat");
				ByteArrayInputStream file = (ByteArrayInputStream) localServletContext
						.getResourceAsStream("/WEB-INF/classes/data-sources.xml");
				document = documentBuilder.parse(file);
				nodeList = document.getElementsByTagName("data-source");
				node = nodeList.item(0);
				namedNodeMap = node.getAttributes();
				String connection_driver = namedNodeMap.getNamedItem("connection-driver").getTextContent();
				String url = namedNodeMap.getNamedItem("url").getTextContent();
				String username = namedNodeMap.getNamedItem("username").getTextContent();
				String password = namedNodeMap.getNamedItem("password").getTextContent();

				Class.forName(connection_driver);
				Connection localConnection = DriverManager.getConnection(url, username, password);

				Statement localStatement = localConnection.createStatement();

				localResultSet = localStatement
						.executeQuery("select RETURNSTACK1 from REPORTLOG where FOLIOID = '" + str2 + "'");
				str3 = clobData(localResultSet, localClob, str3);
				localConnection.close();
			} else if (servNm.startsWith("JBoss Web") || servNm.startsWith("WildFly ")) {
				// log.error("into JBOSS");
				BufferedInputStream file = (BufferedInputStream) localServletContext
						.getResourceAsStream("/WEB-INF/classes/data-sources.xml");
				document = documentBuilder.parse(file);
				nodeList = document.getElementsByTagName("data-source");
				node = nodeList.item(0);
				namedNodeMap = node.getAttributes();
				String server_location = namedNodeMap.getNamedItem("server-location").getTextContent();

				DataSource dataSource = (DataSource) InitialContext.doLookup(server_location);
				PreparedStatement preparedStatement = dataSource.getConnection()
						.prepareStatement("select RETURNSTACK1 from REPORTLOG where FOLIOID = '" + str2 + "'");
				localResultSet = preparedStatement.executeQuery();
				str3 = clobData(localResultSet, localClob, str3);
				preparedStatement.close();
			}

		} catch (Exception localException) {
			log.error(localException);
		}

		paramHttpServletResponse.setContentType("application/vnd.ms-excel");
		paramHttpServletResponse.setDateHeader("Expires", 0L);

		paramHttpServletResponse.addHeader("Content-Disposition", "attachment; filename=" + str1);
		ServletOutputStream localServletOutputStream = paramHttpServletResponse.getOutputStream();
		base64DecodeAndCopyStream(IOUtils.toInputStream(str3), localServletOutputStream, false);

		localServletOutputStream.flush();
		localServletOutputStream.close();
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

	protected void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
			throws ServletException, IOException {
		doGet(paramHttpServletRequest, paramHttpServletResponse);
	}

	String clobData(ResultSet resultSet, Clob localClob, String str3) throws SQLException {
		while (resultSet.next()) {

			localClob = resultSet.getClob(1);
		}
		if (localClob != null) {
			str3 = localClob.getSubString(1L, (int) localClob.length());
		}
		return str3;
	}

}
