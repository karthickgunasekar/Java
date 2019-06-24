package com.volante.services;

import java.rmi.RemoteException;

import javax.naming.NamingException;

import com.tplus.transform.runtime.DataObject;
import com.tplus.transform.runtime.DataObjectSection;
import com.tplus.transform.runtime.LookupContextFactory;
import com.tplus.transform.runtime.MessageFlow;
import com.tplus.transform.runtime.TransformContext;
import com.tplus.transform.runtime.TransformContextImpl;
import com.tplus.transform.runtime.TransformException;

import oracle.sql.BLOB;
import oracle.sql.TIMESTAMP;

public class CallVolanteFlow implements Runnable,DemoInterface{
	static MessageFlow msgFlw = null;
	static String valueStr = null;
	
	public CallVolanteFlow(String val){
		valueStr = val;
	}
	public static void main(String[] args) {	
		DataObject do1=(DataObject) DataObjectSection.class.newInstance();
		
		
		
		
		CallVolanteFlow callVolanteFlow1 = new CallVolanteFlow("1");
		callVolanteFlow1.run();
		System.out.println(DemoInterface._UUID);
		CallVolanteFlow callVolanteFlow2 = new CallVolanteFlow("2");
		callVolanteFlow2.run();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			msgFlw = LookupContextFactory.getLookupContext().lookupMessageFlow("Flow");
			Object[] obj= {"Flow "+valueStr};
			obj= msgFlw.run(obj, new TransformContextImpl());
			System.out.println((String)obj[0]);
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
	}
}
