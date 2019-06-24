package com.volantetech;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.tools.TextToPDF;

public class WritePDFBox {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(new Date().toString());
		byte[] byt = new byte[2];
		byte[] pdfbyte = new byte[2];
		int byteSize = 0;
		Reader fr = new FileReader("C:\\Users\\karthick\\Desktop\\ECTRMPE_220_O0002_R0002.txt");
		TextToPDF ttp = new TextToPDF();
		PDDocument pdd = ttp.createPDFFromText(fr);	
		System.out.println(pdd.getNumberOfPages());
		int totalPages= pdd.getNumberOfPages();
		
		/*InputStream is = new ByteArrayInputStream(byt,0,-1);
		pdd.load(is);*/
		FileOutputStream fos = new FileOutputStream("F:/1223455.pdf");
		pdd.save(fos);
		/*for(int i =0;i<totalPages;i++) {
		is = pdd.getPage(i).getContents();
		System.out.println(is .available());
		is.read(byt, 0, -1);
		
		}*/
		//PDStream pds = new PDStream(pdd.getDocument());
		//byte[] pdfByte=pds.toByteArray();
		//System.out.println(pdfByte.length);
		pdd.close();
		
		//	InputStream is = (InputStream)pds.createInputStream();
		/*FileOutputStream fos = new FileOutputStream("F:/1223.pdf");
		System.out.println("byte = " +byt.length);
		byte[] b = new byte[byt.length];
		*///is.read(b, 0, b.length);
		//IOUtils.copy(is, fos);
		//fos.write(byt);
		//	is.close();
		fos.flush();
		fos.close();
		System.out.println(new Date().toString());
	}

}
