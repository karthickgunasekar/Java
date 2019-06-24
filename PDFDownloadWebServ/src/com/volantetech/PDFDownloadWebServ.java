package com.volantetech;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.ByteBuffer;
import com.lowagie.text.pdf.PdfWriter;

import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tplus.transform.runtime.LookupContext;
import com.tplus.transform.runtime.LookupContextFactory;
import com.tplus.transform.runtime.MessageFlow;
import com.tplus.transform.runtime.RawMessage;
import com.tplus.transform.runtime.TransformContext;
import com.tplus.transform.runtime.TransformContextImpl;
import com.tplus.transform.runtime.TransformException;

@WebServlet("/DownloadPDF")
public class PDFDownloadWebServ extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		String folioID = "71216d53-82ae-4d9b-9718-ab67a5ad4e9c";
		byte[] pdfValue = null;
		try {
			ServletOutputStream sos = res.getOutputStream();
			LookupContext lcxt = LookupContextFactory.getLookupContext();
			MessageFlow mf = lcxt.lookupMessageFlow("DownloadFileOnFolio_ID_Test");
			TransformContext tcxt = new TransformContextImpl();
			Object[] output = mf.run(new Object[] { folioID }, tcxt);
			RawMessage rawOut = null;
			if (output.length > 0) {
				rawOut = (RawMessage) output[0];
				pdfValue = rawOut.getAsBytes();
			}
			Document doc = new Document();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos.write(pdfValue, 0, pdfValue.length);
			 PdfWriter.getInstance(doc, baos);
			doc.open();
			doc.add(new Paragraph(rawOut.getAsString()));
			doc.close();
			/*PDDocument pdd = new PDDocument();
			
			PDDocument pddNew =pdd.load(pdfValue);
			PDStream pds = new PDStream(pddNew);
			InputStream is = (InputStream)pds.createInputStream();
			
			
			System.out.println("");*/
			// 

			/*
			 * baos.write(pdfValue, 0, pdfValue.length); baos.flush(); baos.close();
			 */
			byte[] pdfByt = baos.toByteArray();
			ByteArrayInputStream bais = new ByteArrayInputStream(pdfByt);
			res.addHeader("Content-Disposition", "attachment; filename=1.pdf");
			res.setContentType("application/pdf");
			FileOutputStream fos = new FileOutputStream("F:/12.pdf");
			fos.write(pdfValue, 0, pdfValue.length);
			IOUtils.copy(bais, sos);
			sos.flush();
			sos.close();
			baos.close();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
			throws ServletException, IOException {
		doGet(paramHttpServletRequest, paramHttpServletResponse);
	}
}
