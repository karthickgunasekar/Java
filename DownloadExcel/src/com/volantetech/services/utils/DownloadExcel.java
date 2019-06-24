package com.volantetech.services.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.commons.io.IOUtils;

import com.tplus.transform.util.log.Log;
import com.tplus.transform.runtime.LookupContext;
import com.tplus.transform.runtime.LookupContextFactory;
import com.tplus.transform.runtime.MessageFlow;
import com.tplus.transform.runtime.TransformContext;
import com.tplus.transform.runtime.TransformContextImpl;
import com.tplus.transform.runtime.TransformException;
import com.tplus.transform.runtime.log.LogFactory;

@WebServlet({ "/DownloadExcel" })
public class DownloadExcel extends HttpServlet {

	protected void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
			throws ServletException, IOException {
		String[] arrayOfString1= paramHttpServletRequest.getParameter("FolioID").split(",");
		String[] arrayOfString2 = paramHttpServletRequest.getParameter("PdfCsv").split(",");
		String str1 = "";
		String str2 = "";
		String str4 = "";

		Log log = LogFactory.getRuntimeLog();
		if (arrayOfString1.length > 0) {
			str2 = arrayOfString1[0];
		}

		if (arrayOfString1.length > 1) {
			str1 = arrayOfString1[1] + ".xls";
		}
		if (arrayOfString2.length > 0) {
			str4 = arrayOfString2[0];
			log.error(str4);
		}

		String str3 = "";

		try {
			LookupContext lookupContext = LookupContextFactory.getLookupContext();
			MessageFlow messageFlow = lookupContext.lookupMessageFlow("DownloadReportOnFolio_ID");
			TransformContext transformContext = new TransformContextImpl();
			Object[] rawIn = new Object[] { str2, str4};
			Object[] objOut = messageFlow.run(rawIn, transformContext);
			if (objOut != null) {
				str3 = (String) objOut[0];
			}
		} catch (NamingException | TransformException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

}
