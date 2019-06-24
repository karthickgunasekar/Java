package com.volantetech.services.utils;

import java.rmi.RemoteException;

import javax.naming.NamingException;

import com.tplus.transform.runtime.LookupContext;
import com.tplus.transform.runtime.LookupContextFactory;
import com.tplus.transform.runtime.MessageFlow;
import com.tplus.transform.runtime.TransformContext;
import com.tplus.transform.runtime.TransformContextImpl;
import com.tplus.transform.runtime.TransformException;

public class Downloadcsvpdf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="377DAD8707FE48708D24FBCD635C565F";
		String str2="csv";
		String str3="";
		String str4="";
		try {
			LookupContext lookupContext = LookupContextFactory.getLookupContext();
			MessageFlow messageFlow = lookupContext.lookupMessageFlow("DownloadReportOnFolio_ID");
			TransformContext transformContext = new TransformContextImpl();
			Object[] rawIn = new Object[] { str1, str2};
			Object[] objOut = messageFlow.run(rawIn, transformContext);
			System.out.println("="+objOut.length);
			if (objOut != null) {
				if(objOut.length>0) {
				str3 = (String) objOut[0];
				System.out.println("==="+str3);
				}	
				
				if(objOut.length>1) {
					
					str4 = (String) objOut[1];
					System.out.println(str4);
					}
			}
		} catch (NamingException | TransformException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
