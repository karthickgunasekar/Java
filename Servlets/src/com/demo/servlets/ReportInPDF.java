package com.demo.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.commons.io.IOUtils;


public class ReportInPDF extends HttpServlet {
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			    throws ServletException, IOException
			  {
		 System.out.println("=   "+req.getParameter("file"));
			    resp.setContentType("application/octet-stream");
			    resp.setDateHeader("Expires", 0L);
			    resp.addHeader("Content-Disposition", "attachment; filename=report.pdf");

			    OutputStream os = resp.getOutputStream();
			    base64DecodeAndCopyStream(IOUtils.toInputStream(req.getParameter("file")), os, false);
			    os.flush();
			    os.close();
			    System.out.println(resp.getContentType());
			  }

			  private void copyStream(InputStream is, OutputStream os, boolean closeOutputSteam) throws IOException
			  {
			    byte[] buffer = new byte[256];
			    int bytesRead = 0;
			    while ((bytesRead = is.read(buffer)) != -1) {
			      os.write(buffer, 0, bytesRead);
			    }
			    if (closeOutputSteam)
			      os.close();
			  }

			  private void base64DecodeAndCopyStream(InputStream is, OutputStream os, boolean closeOutputStream) throws IOException {
			    Base64InputStream base64InputStream = new Base64InputStream(is);
			    copyStream(base64InputStream, os, false);
			  }
/*			  public static void main(String[] args) throws IOException {
				    String value = "QWxkcmluZQ==";
				    OutputStream outputStream = new BufferedOutputStream(System.out);
				    SaveFile saveFile = new SaveFile();
				    saveFile.base64DecodeAndCopyStream(IOUtils.toInputStream(value), outputStream, false);
				    System.out.println(value);
				  }*/
}
