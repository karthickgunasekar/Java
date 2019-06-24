package com.volante.services.test.createpdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.naming.NamingException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import com.tplus.transform.runtime.LookupContext;
import com.tplus.transform.runtime.LookupContextFactory;
import com.tplus.transform.runtime.MessageFlow;
import com.tplus.transform.runtime.RawMessage;
import com.tplus.transform.runtime.TransformContext;
import com.tplus.transform.runtime.TransformContextImpl;
import com.tplus.transform.runtime.TransformException;
import com.volante.services.createpdf.CreatePDFFile;

public class CreatePdfTest {

	RawMessage raw = null;
	public RawMessage callVolante() {
		TransformContext tc = new TransformContextImpl();
		RawMessage rawOut = null;
		try {
			
			LookupContext lc = LookupContextFactory.getLookupContext();
			MessageFlow mf = lc.lookupMessageFlow("VLReportsGenerate");
			Object[] obj = { "daily" };
			Object[] r = mf.run(obj, tc);
			if (r != null && r.length > 0) {
				if (r[0] instanceof RawMessage) {
					rawOut = (RawMessage) r[0];
					
				}
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rawOut;
	}

	public static void main(String[] args) throws TransformException {
		// TODO Auto-generated method stub
		
		CreatePdfTest cpt = new CreatePdfTest();
		cpt.raw = cpt.callVolante();
		
	
			new CreatePDFFile(new String(cpt.raw.getAsBytes()));
			
		


	}

}
