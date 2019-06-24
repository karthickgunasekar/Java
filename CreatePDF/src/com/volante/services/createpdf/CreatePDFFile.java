package com.volante.services.createpdf;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.camel.CamelContext;
import org.apache.camel.Consumer;
import org.apache.camel.Endpoint;
import org.apache.camel.EndpointConfiguration;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.PollingConsumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.fontbox.encoding.Encoding;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding;

public class CreatePDFFile implements Processor {

	static PDDocument pddoc = new PDDocument();
	String folderPath = null;
	static PDPage pdp = new PDPage();
	static PDFont pdf = PDType1Font.TIMES_ROMAN;	
	static PDPageContentStream pdpcs = null;

	public CreatePDFFile(String str) {

		getResourcesFrmConfig();

		pddoc.addPage(pdp);
				
		try {
			pdpcs = new PDPageContentStream(pddoc, pdp);
			pdpcs.beginText();
			pdf= PDType0Font.load(pddoc, new File("C:/Windows/Fonts/lucon.ttf"));
			pdpcs.setFont(pdf, 14);
			pdpcs.drawString(str);
			pdpcs.endText();
			pdpcs.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		savePdfFile(pddoc);
	}

	public void getResourcesFrmConfig() {
		// System.out.println(this.getClass().getClassLoader().getResource("./dev_reportprocessing_config.properties").getPath());
		InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream("/G:/git/CreatePDF/WEB-INF/classes/dev_reportprocessing_config.properties");
		try {
			// System.out.println("-"+System.getProperty("user.dir"));
			Properties prop = new Properties();
			if (is != null) {
				prop.load(is);
				folderPath = prop.getProperty("ReportFolderPath");
				System.out.println("Folder " + folderPath);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void savePdfFile(PDDocument pddoc) {
		try {
			pddoc.save(folderPath + "");
			pddoc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void process(Exchange arg0) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * for(String obj: arg0.getProperties().keySet()) System.out.println(obj);
		 */
		// System.out.println(arg0.getException());

	}

}
